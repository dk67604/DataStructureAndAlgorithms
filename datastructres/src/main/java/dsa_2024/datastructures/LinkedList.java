package main.java.dsa_2024.datastructures;

public class LinkedList {

    ListNode head;

    public LinkedList(){
        this.head = null;
    }

    public void addToTail(int val){
        ListNode listNode = new ListNode(val);
        if (head == null){
            this.head = listNode;
            return;
        }
        ListNode current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = listNode;
        return;
    }

    public void addToHead(int val){
        ListNode listNode = new ListNode(val);
        if (head == null){
            this.head = listNode;
            return;
        }
        listNode.next = this.head;
        this.head = listNode;
    }

    public void traverse(){
        if (head == null){
            System.out.println("List is empty");
        }
        ListNode current = this.head;
        while (current!=null) {
            if (current.next == null){
                System.out.println(current.val + " -> None");
            }else{
                System.out.print(current.val + " -> ");
            }

            current = current.next;
        }
    }
    public boolean delete(int val){
        if (head == null){
            System.out.println("List is empty");
        }
        ListNode current = this.head;
        ListNode previous = current;
        while (current != null) {
            if (current.val == val){
                ListNode temp = current.next;
                previous.next = temp;
                current.next = null;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,7,9};
        LinkedList linkedList = new LinkedList();
        for (int num : nums){
            linkedList.addToTail(num);
        }
        linkedList.traverse();
        linkedList.delete(2);
        linkedList.traverse();
    }
}
