package main.java.dsa_2024.systemdesign;

import java.util.*;
class Node{
    int key;
    int val;
    int freq;
    Node prev, next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        freq = 1;
    }
}

class DLList{
    Node head, tail;
    int size;
    public DLList(){
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void add(Node node){
        // add always to the head
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
        size++;
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public Node removeLast(){
        if(size > 0){
            Node node = tail.prev;
            remove(node);
            return node;
        }
        return null;
    }
}

public class LFUCache {
    // min frequency in overall cache
    int capacity, size, min;
    Map<Integer, Node> nodeMap; // key
    Map<Integer, DLList> countMap; //frequency of key
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

    public void put(int key, int val){
        if( capacity == 0) return;
        Node node;
        if(nodeMap.containsKey(key)){
            node = nodeMap.get(key);
            node.val = val;
            update(node);
        }
        else{
            node = new Node(key, val);
            nodeMap.put(key, node);
            if(size == capacity){
                // Make space for new one by removing least frequently used
                DLList lastList = countMap.get(min);
                nodeMap.remove(lastList.removeLast().key);
                size--;
            }
            size++;
            min = 1;
            DLList newList = countMap.getOrDefault(node, new DLList());
            newList.add(node);
            countMap.put(node.freq, newList);
        }
    }

    public void update(Node node){
        // Remove the node
        DLList oldList = countMap.get(node.freq);
        oldList.remove(node);
        // Update the overall min frequency of cache
        if(node.freq == min && oldList.size == 0) min++;
        //Update fequency map
        node.freq++;
        DLList newList = countMap.getOrDefault(node.freq, new DLList());
        newList.add(node);
        countMap.put(node.freq, newList);
    }
}
