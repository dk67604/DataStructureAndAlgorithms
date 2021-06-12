package main.java.topcodingquestion.treesandgraphs;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextPointerInEachNode {
    //Using BFS
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node previousNode = null;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                if (previousNode != null) {
                    previousNode.next = currentNode;
                }
                previousNode = currentNode;
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return root;
    }

    //Using O(1) space
    public Node connectII(Node root) {
        if (root == null) return root;
        // Start with the root node. There are no next pointers
        // that need to be set up on the first level
        Node leftmost = root;
        while (leftmost.left != null) {
            // Iterate the "linked list" starting from the head
            // node and using the next pointers, establish the
            // corresponding links for the next level
            Node head = leftmost;
            while (head != null) {
                //Connection 1
                head.left.next = head.right;

                //Connection 2
                if (head.next != null)
                    head.right.next = head.next.left;
                // Progress along the list (nodes on the current level)
                head = head.next;
            }
            // Move onto the next level
            leftmost = leftmost.left;
        }
        return root;
    }
}
