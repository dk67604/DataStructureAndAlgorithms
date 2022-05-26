package main.java.topcodingquestion.linkedlist;
//https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/
public class InsertToCircularLinkedList {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node temp = new Node(insertVal);
            temp.next = temp;
            return temp;
        }
        Node prev = head, curr = head.next;
        boolean isInsert = false;
        while (true) {

            if (prev.val <= insertVal && insertVal <= curr.val) {
                //Case 1
                isInsert = true;
            } else if (prev.val > curr.val) {
                //Case 2
                // where we locate the tail element
                // 'prev' points to the tail, i.e. the largest element!
                if (insertVal >= prev.val || insertVal <= curr.val) {
                    isInsert = true;
                }
            }
            if (isInsert) {
                prev.next = new Node(insertVal, curr);
                return head;
            }
            prev = curr;
            curr = curr.next;
            if (prev == head)
                break;
        }
        //Case #3.
        //did not insert the node in the loop
        prev.next = new Node(insertVal, curr);
        return head;
    }
}
