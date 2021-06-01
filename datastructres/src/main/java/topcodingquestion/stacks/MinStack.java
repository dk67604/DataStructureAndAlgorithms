package main.java.topcodingquestion.stacks;

public class MinStack {
    Node head;

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        Node next;
        int min;

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int minMax, Node next) {
            this.val = val;
            this.min = minMax;
            this.next = next;
        }
    }

}
