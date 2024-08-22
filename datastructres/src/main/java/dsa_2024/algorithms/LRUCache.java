package main.java.dsa_2024.algorithms;

import java.util.*;;

class DLinkedNode{
    int key;
    int val;
    DLinkedNode pre;
    DLinkedNode post;
}

public class LRUCache {
    Hashtable<Integer, DLinkedNode> cache = new Hashtable<>();
    DLinkedNode head;
    DLinkedNode tail;
    int count;
    int capacity;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.count = 0;
        head = new DLinkedNode();
        head.pre = null;
        tail = new DLinkedNode();
        tail.post = null;
        head.post = tail;
        tail.pre = head;
    }

    private void addNode(DLinkedNode node){
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }

    private void removeNode(DLinkedNode node){
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;
        pre.post = post;
        post.pre = pre;
    }

    private void moveToHead(DLinkedNode node){
        this.removeNode(node);
        this.addNode(node);
    }

    private DLinkedNode popTail(){
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    public int get(int key){
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        this.moveToHead(node);
        return node.val;
    }

    public void put(int key, int value){
        DLinkedNode node = cache.get(key);
        if(node == null){
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.val = value;
            this.addNode(newNode);
            this.cache.put(key, newNode);
            ++count;
            if(count > capacity){
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        }else{
            node.val = value;
            this.moveToHead(node);
        }
    }

}
