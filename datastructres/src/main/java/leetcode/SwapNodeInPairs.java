package main.java.leetcode;


public class SwapNodeInPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        SwapNodeInPairs swapNodeInPairs = new SwapNodeInPairs();
        head = swapNodeInPairs.swapPairs(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            ListNode f1 = curr.next;
            ListNode f2 = curr.next.next;
            f1.next = f2.next;
            curr.next = f2;
            curr.next.next = f1;
            curr = curr.next.next;


        }
        return dummy.next;
    }
}
