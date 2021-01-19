package main.java.systemdesign.cache;

import java.util.Hashtable;

public class LRUCache {

    private Hashtable<Integer,DLinkedNode> cache = new Hashtable<>();
    private int count;
    private int capacity;
    private DLinkedNode head,tail;
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    /**
     * Always add node just after the head
     */
    private void addNode(DLinkedNode node){
        //Maintain the same order to add Node
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }

    /**
     * Remove an existing node from the linked list
     */
    private void removeNode(DLinkedNode node){
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;
        pre.post = post;
        post.pre = pre;
    }

    /**
     * Move certain node in between to head
     */
    private void moveToHead(DLinkedNode node){
        this.removeNode(node);
        this.addNode(node);
    }

    /**
     * pop the current tail
     */
    private DLinkedNode popTail(){
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }


    /**
     * Initialize LRU Cache
     */
    public LRUCache(int capacity){
        this.count =0;
        this.capacity = capacity;
        head = new DLinkedNode();
        head.pre = null;
        tail = new DLinkedNode();
        tail.post =null;
        head.post = tail;
        tail.pre = head;
    }

    public int get(int key){
        DLinkedNode node = cache.get(key);
        //Node doesn't exist
        if(node == null){
            return -1;
        }
        //move this node to the head
        this.moveToHead(node);
        return node.value;
    }

    public void put(int key,int value){
        DLinkedNode node = cache.get(key);
        //Key doesn't exist
        if(node == null){
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            this.addNode(newNode);
            this.cache.put(key,newNode);
            ++count;
            if(count>capacity){
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        }else {
            //Update the existing value
            node.value = value;
            this.moveToHead(node);
        }
    }
}
