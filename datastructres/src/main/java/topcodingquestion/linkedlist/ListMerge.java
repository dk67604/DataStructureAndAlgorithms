package main.java.topcodingquestion.linkedlist;

public class ListMerge {

    //https://leetcode.com/problems/merge-two-sorted-lists/
    public Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        Node preHead = new Node(-1);
        Node prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }
}
