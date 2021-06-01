package main.java.topcodingquestion.linkedlist;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}