package main.java.topcodingquestion.linkedlist;

public class DetectLoopInSLL {
    public boolean detectLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.val == fast.val) {
                return true;
            }
        }
        return false;
    }
}
