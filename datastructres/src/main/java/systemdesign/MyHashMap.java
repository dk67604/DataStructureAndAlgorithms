package main.java.systemdesign;

public class MyHashMap {

    private  static class ListNode{
        int key,val;
        ListNode next;
        ListNode(int key,int val){
            this.key = key;
            this.val = val;
        }
    }

    ListNode[] nodes ;

    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new ListNode[10000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key); // get the index
        ListNode prev = findElement(index,key);
        if(prev.next == null)
            //Create new key-value node and link it to previous node
            prev.next = new ListNode(key,value);
        else {

            //Update the key with new value
            prev.next.val =value;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        ListNode prev = findElement(index,key);
        return prev.next == null? -1:prev.next.val;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        ListNode prev = findElement(index,key);
        if(prev.next!=null){
            prev.next =prev.next.next;
        }
    }

    private int getIndex(int key){
        return Integer.hashCode(key) % nodes.length;
    }

    private ListNode findElement(int index,int key){
        if(nodes[index] == null)
            return nodes[index]= new ListNode(-1,-1);
        ListNode prev = nodes[index];
        while (prev.next!=null && prev.next.key!=key ){
            prev= prev.next;
        }
        return prev;
    }

}
