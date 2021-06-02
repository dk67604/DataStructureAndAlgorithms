package main.java.topcodingquestion.linkedlist;


public class SwapNodesInPairs {
    public Node swapPairs(Node head) {
        if (head == null || head.next == null) return head;
        Node dummy = new Node(-1);
        dummy.next = head;
        Node curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            Node f1 = curr.next;
            Node f2 = curr.next.next;
            //Swap steps
            f1.next = f2.next;
            curr.next = f2;
            curr.next.next = f1;
            curr = curr.next.next;
        }
        return dummy.next;
    }
}
