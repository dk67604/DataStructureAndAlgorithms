package main.java.ctci.linkedlist;

import main.java.ctci.datastructure.LinkedListNode;

/*
The intuition to solve this problem is to use fast and slow runner, our assumption if there
a loop then at some point the collision will occur between the two runner
 */
public class LoopDetection {
    public LinkedListNode findBeginning(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;
        /*Find meeting point. This will be LOOP_SIZE -k steps into the linked list */
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { //collision
                break;
            }
        }
        //Error check - no meeting point, and therefore no loop
        if (fast == null || fast.next == null) {
            return null;
        }
        //Move slow to head,keep fast at meeting point. Each are k steps from
        // the loop start. If they move at same pace,they must meet at loop start
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        /*Both now point to start of the loop*/
        return fast;
    }

}
