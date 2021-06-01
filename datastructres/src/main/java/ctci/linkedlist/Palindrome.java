package main.java.ctci.linkedlist;

import main.java.ctci.datastructure.LinkedListNode;

import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        LinkedListNode head = new LinkedListNode(1);
        head = LinkedListNode.insertAtHead(2, head);
        head = LinkedListNode.insertAtHead(3, head);
        head = LinkedListNode.insertAtHead(2, head);
        head = LinkedListNode.insertAtHead(1, head);

        LinkedListNode.print(head);
        System.out.println("Is Palindrome: " + palindrome.checkPalindrome(head));
        System.out.println("Is Palindrome: " + palindrome.isPalindrome(head));
        head = new LinkedListNode(1);
        head = LinkedListNode.insertAtHead(2, head);
        head = LinkedListNode.insertAtHead(3, head);
        head = LinkedListNode.insertAtHead(2, head);
        head = LinkedListNode.insertAtHead(4, head);
        LinkedListNode.print(head);
        System.out.println("Is Palindrome: " + palindrome.checkPalindrome(head));
        System.out.println("Is Palindrome: " + palindrome.isPalindrome(head));

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

    public boolean isPalindrome(LinkedListNode head) {
        int length = LinkedListNode.size(head);
        Result p = isPalindrome(head, length);
        return p.result;

    }

    private Result isPalindrome(LinkedListNode head, int length) {
        if (head == null || length <= 0) { // even number of nodes
            return new Result(head, true);
        } else if (length == 1) { //Odd number of nodes
            return new Result(head.next, true);
        }
        /* Recurse on sub-list */
        Result res = isPalindrome(head.next, length - 2);
        /* if child calls are not palindrome,pass backup failure */
        if (!res.result || res.node == null) {
            return res;
        }
        /*Check if matches corresponding node to other side */
        res.result = (head.data == res.node.data);
        /* Return corresponding node */
        res.node = res.node.next;
        return res;
    }

    class Result {
        LinkedListNode node;
        boolean result;

        public Result(LinkedListNode node, boolean result) {
            this.node = node;
            this.result = result;
        }
    }
}
