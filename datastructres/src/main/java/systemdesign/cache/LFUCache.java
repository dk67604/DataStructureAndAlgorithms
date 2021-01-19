package main.java.systemdesign.cache;

import java.util.HashMap;
import java.util.Map;

class Node{
    int key;
    int val;
    int freq;
    Node prev, next;
    public Node(int key,int val){
        this.key = key;
        this.val = val;
        freq = 1;
    }
}
class DLList{
    Node head, tail;
    int size;
    public DLList(){
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    void add(Node node){
        // add node always in front
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
        size++;
    }
    void remove(Node node){
        // remove the node ;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }
    Node removeLast(){
        if(size > 0){
            Node node = tail.prev;
            remove(node);
            return node;
        }
        else return null;
    }
}

public class LFUCache {
    int capacity,size, min;
    Map<Integer,Node> nodeMap;
    Map<Integer,DLList> countMap;

    public LFUCache(int capacity){
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();

    }

    public int get(int key){
        Node node = nodeMap.get(key);
        if(node == null) return -1;
        update(node);
        return node.val;
    }

    public void put(int key, int value){
        if(capacity == 0) return;
        Node node;
        if(nodeMap.containsKey(key)){
            node = nodeMap.get(key);
            node.val = value;
            update(node);
        }
        else {
            node = new Node(key,value);
            nodeMap.put(key,node);
            if(size == capacity){ //Make space for new one by removing least frequently used node
                DLList lastList = countMap.get(min);
                nodeMap.remove(lastList.removeLast().key);
                size--;
            }
            size++;
            min = 1; // reset minimum frequency
            DLList newList = countMap.getOrDefault(node.freq, new DLList());
            newList.add(node);
            countMap.put(node.freq,newList);
        }
    }

    private void update(Node node){
        //Remove the node
        DLList oldList = countMap.get(node.freq);
        oldList.remove(node);
        //Update overall min frequency of cache
        if(node.freq == min && oldList.size ==0) min++;
        // Update frequency map
        node.freq++;
        DLList newList = countMap.getOrDefault(node.freq, new DLList());
        newList.add(node);
        countMap.put(node.freq,newList);
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1,1);
        lfuCache.put(2,2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3,3);
    }
}
