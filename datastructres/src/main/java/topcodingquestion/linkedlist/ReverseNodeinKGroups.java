package main.java.topcodingquestion.linkedlist;

public class ReverseNodeinKGroups {
    /*
    * Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting from the head.

    If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
     */
    public static Node reverse(Node head, int k) {
        if (k <= 1 || head == null)
            return head;

        Node current = head, previous = null;
        while (true) {
            Node lastNodeOfPreviousPart = previous;
            // after reversing the LinkedList 'current' will become the last node of the sub-list
            Node lastNodeOfSubList = current;
            Node next = null; // will be used to temporarily store the next node
            // reverse 'k' nodes
            for (int i = 0; current != null && i < k; i++) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            // connect with the previous part
            if (lastNodeOfPreviousPart != null)
                lastNodeOfPreviousPart.next = previous; // 'previous' is now the first node of the sub-list
            else // this means we are changing the first node (head) of the LinkedList
                head = previous;

            // connect with the next part
            lastNodeOfSubList.next = current;

            if (current == null) // break, if we've reached the end of the LinkedList
                break;
            // prepare for the next sub-list
            previous = lastNodeOfSubList;
        }

        return head;
    }

    public static void main(String[] args) {
        ReverseNodeinKGroups reverseNodeinKGroups = new ReverseNodeinKGroups();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        System.out.println(reverseNodeinKGroups.reverseKGroup(head, 3));
    }

    /*
    Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting from the head.

If, in the end, you are left with a sub-list with less than ‘k’ elements, remain same.
     */
    public Node reverseKGroup(Node head, int k) {
        if (k <= 1 || head == null) return head;
        Node current = head, new_head = null, ktail = null;

        while (current != null) {
            int count = 0;
            while (count < k && current != null) {
                current = current.next;
                count += 1;
            }
            if (count == k) {
                Node revHead = reverseLL(head, k);
                // new_head is the head of the final linked list
                if (new_head == null) {
                    new_head = revHead;
                }
                // ktail is the tail of the previous block of
                // reversed k nodes
                if (ktail != null) {
                    ktail.next = revHead;
                }
                ktail = head;
                head = current;

            }

        }
        if (ktail != null) {
            ktail.next = head;
        }
        return new_head != null ? new_head : head;
    }

    private Node reverseLL(Node head, int k) {
        Node current = head, previous = null;
        Node next;
        while (k > 0) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            k--;
        }
        return previous;
    }
}
