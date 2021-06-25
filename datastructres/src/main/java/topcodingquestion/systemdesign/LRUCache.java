package main.java.topcodingquestion.systemdesign;

import java.util.Hashtable;


public class LRUCache {
    Hashtable<Integer, DLinkedNode> cache = new Hashtable<>();
    DLinkedNode head;
    DLinkedNode tail;
    int count;
    int capacity;

    /**
     * Initialize LRU Cache
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        head = new DLinkedNode();
        head.pre = null;
        tail = new DLinkedNode();
        tail.post = null;
        head.post = tail;
        tail.pre = head;
    }

    /**
     * Always add node just after the head
     */
    private void addNode(DLinkedNode node) {
        //Maintain the same order to add Node
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }

    /**
     * Remove an existing node from the linked list
     */
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;
        pre.post = post;
        post.pre = pre;
    }

    /**
     * Move certain node in between to head
     */
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    /**
     * pop the current tail
     */
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //move this node to the head
        this.moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        //key doesn't exist
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.val = value;
            this.addNode(newNode);
            this.cache.put(key, newNode);
            ++count;
            if (count > capacity) {
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {

            node.val = value;
            this.moveToHead(node);
        }
    }

    class DLinkedNode {
        int key;
        int val;
        DLinkedNode pre;
        DLinkedNode post;
    }

}
