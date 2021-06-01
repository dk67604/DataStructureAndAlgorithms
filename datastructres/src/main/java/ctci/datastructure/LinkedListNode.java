package main.java.ctci.datastructure;

public class LinkedListNode {
    public int data;
    public LinkedListNode next;

    public LinkedListNode(int val) {
        this.data = val;
        this.next = null;
    }

    public static void print(LinkedListNode head) {
        LinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static LinkedListNode insertAtHead(int data, LinkedListNode head) {
        LinkedListNode current = new LinkedListNode(data);
        current.next = head;
        head = current;
        return head;
    }

    public static int size(LinkedListNode head) {
        LinkedListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public static LinkedListNode getTail(LinkedListNode head) {
        LinkedListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    public static LinkedListNode insertAtTail(int data, LinkedListNode head) {
        LinkedListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        LinkedListNode temp = new LinkedListNode(data);
        current.next = temp;
        return head;
    }

    public static LinkedListNode insertAtTail(LinkedListNode temp, LinkedListNode head) {
        LinkedListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = temp;
        return head;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }
}
