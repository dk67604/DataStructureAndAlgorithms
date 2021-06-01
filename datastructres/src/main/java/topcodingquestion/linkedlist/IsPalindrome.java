package main.java.topcodingquestion.linkedlist;

import main.java.ctci.datastructure.LinkedListNode;

import java.util.Stack;

public class IsPalindrome {
    Node left;

    public boolean isPalindrome(Node head) {
        left = head;
        boolean result = helper(head);
        return result;
    }

    private boolean helper(Node right) {
        if (right == null) {
            return true;
        }
        boolean x = helper(right.next);
        if (!x) {
            return false;
        }
        boolean result = (left.val == right.val);
        left = left.next;
        return result;
    }

    public boolean checkPalindrome(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        Stack<Integer> stack = new Stack<>();
        /*
        Push the element from the first half of linked list onto stack when fast pointer
        reaches the end of the linked list,then slow pointer will at the middle
         */
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next; //2x speed
        }
        //has odd number of elements, so skip the middle element
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            int data = stack.pop().intValue();
            if (data != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;

    }
}
