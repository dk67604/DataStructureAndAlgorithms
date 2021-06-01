package main.java.ctci.linkedlist;

import main.java.ctci.datastructure.LinkedListNode;

import java.util.HashSet;
import java.util.Set;

public class DeleteDuplicate {
    public static void main(String[] args) {
        LinkedListNode current = new LinkedListNode(1);
        current.next = new LinkedListNode(3);
        current.next.next = new LinkedListNode(1);
        current.next.next.next = new LinkedListNode(4);
        LinkedListNode.print(current);
        DeleteDuplicate deleteDuplicate = new DeleteDuplicate();
        deleteDuplicate.deleteDuplicate(current);
        System.out.println("Linked List after duplicate deletion:");
        LinkedListNode.print(current);
    }

    public void deleteDuplicate(LinkedListNode current) {
        LinkedListNode previous = null;
        Set<Integer> set = new HashSet<Integer>();
        while (current != null) {
            if (set.contains(current.getData())) {
                previous.next = current.next;
            } else {
                set.add(current.data);
                previous = current;
            }
            current = current.next;
        }
    }
}
