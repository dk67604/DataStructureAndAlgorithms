package main.java.topcodingquestion.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CloneALinkedListWithRandomPointer {
    // Recursive function to print a linked list
    public static void traverse(Node head) {
        if (head == null) {
            System.out.println("null");
            return;
        }

        // print current node data and random pointer data
        if (head.random != null) {
            System.out.print(head.val + "(" + head.random.val + ") —> ");
        } else {
            System.out.print(head.val + "(" + "X" + ") —> ");
        }

        // recur for the next node
        traverse(head.next);
    }

    public static Node cloneLinkedList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        // clone data and next pointer for each node of the original
        // linked list and put references into the map
        cloneLinkedList(head, map);
        updateRandomPointers(head, map);
        return head;
    }

    // Recursive function to clone the data and next pointer for each node
    // of the linked list into a given map
    private static Node cloneLinkedList(Node head, Map<Node, Node> map) {
        //base case
        if (head == null) {
            return null;
        }
        // clone all fields of the head node except the random pointer
        // create a new node with the same data as the head node
        map.put(head, new Node(head.val));
        // clone the next node
        map.get(head).next = cloneLinkedList(head.next, map);
        // return cloned head node
        return map.get(head);
    }

    private static void updateRandomPointers(Node head, Map<Node, Node> map) {
        //base case
        if (map.get(head) == null) {
            return;
        }
        // update the random pointer of the cloned node
        map.get(head).random = map.get(head.random);
        // recur for the next node
        updateRandomPointers(head.next, map);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head.random = head.next.next.next;
        head.next.next.random = head.next;

        System.out.println("Original Linked List:");
        traverse(head);

        Node clone = cloneLinkedList(head);

        System.out.println("\nCloned Linked List:");
        traverse(clone);
    }
}
