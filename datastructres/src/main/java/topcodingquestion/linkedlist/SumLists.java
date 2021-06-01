package main.java.topcodingquestion.linkedlist;


public class SumLists {
    private Node reverseNode(Node head) {
        Node previous = null;
        Node next = null;
        Node current = head;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public Node sumLists(Node l1, Node l2) {
        Node head = null;
        l1 = reverseNode(l1);
        l2 = reverseNode(l2);
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x1 = l1 != null ? l1.val : 0;
            int x2 = l2 != null ? l2.val : 0;
            int data = (carry + x1 + x2) % 10;
            carry = (carry + x1 + x2) / 10;
            Node current = new Node(data);
            current.next = head;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            head = current;
        }
        if (carry != 0) {
            Node current = new Node(carry);
            current.next = head;
            head = current;
        }
        return head;
    }

}
