package main.java.systemdesign;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class Node {
    int val;
    Node prev, next;

    public Node(int val) {
        this.val = val;
    }
}

class DLList {
    Node head, tail;

    public DLList() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    Node add(int val) {
        Node x = new Node(val);
        x.next = tail;
        x.prev = tail.prev;
        tail.prev = tail.prev.next = x;
        return x;
    }

    Node remove(Node node) {
        // remove the node ;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;

    }

    int pop() {
        return remove(tail.prev).val;
    }

    int peek() {
        return tail.prev.val;
    }

}

public class MaxStack {
    TreeMap<Integer, List<Node>> map;
    DLList dll;

    public MaxStack() {
        map = new TreeMap<>();
        dll = new DLList();
    }

    public void push(int x) {
        Node node = dll.add(x);
        map.putIfAbsent(x, new ArrayList<>());
        map.get(x).add(node);

    }

    public int pop() {
        int val = dll.pop();
        List<Node> list = map.get(val);
        list.remove(list.size() - 1);
        if (list.isEmpty()) map.remove(val);
        return val;
    }

    public int top() {
        return dll.peek();
    }

    public int peekMax() {
        return map.lastKey();
    }

    public int popMax() {
        int max = peekMax();
        List<Node> list = map.get(max);
        Node node = list.remove(list.size() - 1);
        dll.remove(node);
        if (list.isEmpty()) map.remove(max);
        return max;


    }
}
