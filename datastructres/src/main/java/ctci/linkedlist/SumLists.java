package main.java.ctci.linkedlist;

import main.java.ctci.datastructure.LinkedListNode;

public class SumLists {

    public static void main(String[] args) {
        LinkedListNode l1 = new LinkedListNode(9);
        l1.next = new LinkedListNode(8);
        l1.next.next = new LinkedListNode(4);
        LinkedListNode l2 = new LinkedListNode(4);
        l2.next = new LinkedListNode(5);
        SumLists sumLists = new SumLists();
        LinkedListNode.print(l1);
        LinkedListNode.print(l2);
        LinkedListNode sumList = sumLists.sumList(l1, l2);
        LinkedListNode.print(sumList);
    }

    private LinkedListNode reverseList(LinkedListNode head) {
        LinkedListNode previous = null;
        LinkedListNode next = null;
        LinkedListNode current = head;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;

    }

    public LinkedListNode sumList(LinkedListNode l1, LinkedListNode l2) {
        LinkedListNode head = null;

        int carry = 0;
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        while (l1 != null || l2 != null) {
            // get the current values
            int x1 = l1 != null ? l1.data : 0;
            int x2 = l2 != null ? l2.data : 0;
            // current sum and carry
            int data = (carry + x1 + x2) % 10;
            carry = (carry + x1 + x2) / 10;
            LinkedListNode current = new LinkedListNode(data);
            current.next = head;
            // move to the next elements in the lists
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            head = current;
        }
        if (carry != 0) {
            LinkedListNode current = new LinkedListNode(carry);
            current.next = head;
            head = current;

        }
        return head;
    }
}
