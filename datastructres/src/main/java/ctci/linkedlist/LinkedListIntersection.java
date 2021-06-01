package main.java.ctci.linkedlist;

import main.java.ctci.datastructure.LinkedListNode;

class ResultIntersection {
    int size;
    LinkedListNode tail;

    public ResultIntersection(LinkedListNode tail, int size) {
        this.tail = tail;
        this.size = size;
    }
}

public class LinkedListIntersection {
    public static void main(String[] args) {
        LinkedListNode l1 = new LinkedListNode(3);
        l1 = LinkedListNode.insertAtTail(1, l1);
        l1 = LinkedListNode.insertAtTail(5, l1);
        l1 = LinkedListNode.insertAtTail(9, l1);
        l1 = LinkedListNode.insertAtTail(7, l1);
        LinkedListNode intersection = LinkedListNode.getTail(l1);
        l1 = LinkedListNode.insertAtTail(2, l1);
        l1 = LinkedListNode.insertAtTail(1, l1);
        LinkedListNode l2 = new LinkedListNode(4);
        l2 = LinkedListNode.insertAtTail(6, l2);
        l2 = LinkedListNode.insertAtTail(intersection, l2);
        LinkedListNode.print(l1);
        LinkedListNode.print(l2);
        LinkedListIntersection linkedListIntersection = new LinkedListIntersection();

        System.out.println("Intersection Node:" + linkedListIntersection.findIntersection(l1, l2).data);
    }

    public LinkedListNode findIntersection(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ResultIntersection result1 = getTailAndSize(l1);
        ResultIntersection result2 = getTailAndSize(l2);

        LinkedListNode shorter = result1.size < result2.size ? l1 : l2;
        LinkedListNode longer = result1.size < result2.size ? l2 : l1;
        /*Advance the pointer of longer linked list by the difference in length*/
        longer = getKthNode(longer, Math.abs(result1.size - result2.size));
        /*Move the shorter and longer linked list until you have a collision*/
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }
        /*Return either one*/
        return longer;

    }

    private ResultIntersection getTailAndSize(LinkedListNode head) {
        int size = LinkedListNode.size(head);
        LinkedListNode tail = LinkedListNode.getTail(head);
        return new ResultIntersection(tail, size);
    }

    private LinkedListNode getKthNode(LinkedListNode head, int k) {
        LinkedListNode current = head;
        while (k > 0 & current != null) {
            k--;
            current = current.next;
        }
        return current;
    }
}
