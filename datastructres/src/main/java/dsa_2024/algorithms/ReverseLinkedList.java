package main.java.dsa_2024.algorithms;

import main.java.dsa_2024.datastructures.LinkedList;
import main.java.dsa_2024.datastructures.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head){
        ListNode current = head;
        ListNode previous = null;
        ListNode nextCurrent = null;
        while (current != null) {
            nextCurrent = current.next;
            current.next = previous;
            previous = current;
            current = nextCurrent;

        }
        return previous;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7,8,9};
        LinkedList linkedList = new LinkedList();
        for(int num : nums){
            linkedList.addToTail(num);
        }
        linkedList.traverse();
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode reverseHead = reverseLinkedList.reverseList(linkedList.getHead());
        linkedList.setHead(reverseHead);
        linkedList.traverse();
    }
}
