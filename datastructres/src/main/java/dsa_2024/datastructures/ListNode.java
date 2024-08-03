package main.java.dsa_2024.datastructures;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }

    public ListNode(){
    }

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
