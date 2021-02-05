package main.java.techiedelight.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InvertAlternateLevels {
    public static void main(String[] args) {
        /* Construct the following tree
                    1
                  /   \
                /       \
              2           3
            /   \       /   \
           4     5     6     7
          / \   / \   / \   / \
         8   9 10 11 12 13 14 15
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);
        InvertAlternateLevels invertAlternateLevels = new InvertAlternateLevels();
        invertAlternateLevels.invertBinaryTree(root);
        invertAlternateLevels.levelOrderTraversal(root);
    }

    // Function to print level order traversal of a perfect binary tree
    public void levelOrderTraversal(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // process each node in the queue and enqueue their
            // non-empty left and right child
            Node curr = queue.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }

    }

    public void invertBinaryTree(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean level = false;
        // maintain another queue to store nodes present at an odd level
        Queue<Node> levelNode = new LinkedList<>();
        // maintain a stack to store node's data on an odd level
        Stack<Integer> levelData = new Stack<>();
        while (!queue.isEmpty()) {
            int n = queue.size();
            while (n-- > 0) {
                // process each node in the queue and enqueue their
                // non-empty left and right child
                Node curr = queue.poll();
                // if the level is odd
                if (level) {
                    // enqueue current node
                    levelNode.offer(curr);
                    // push the current node data into the stack
                    levelData.add(curr.data);
                }
                // if the current node is the last node of the level
                if (n == 0) {
                    //flip the level
                    level = !level;
                    // put elements present in the `levelData` into their correct
                    // position using `levelNodes`
                    while (!levelNode.isEmpty()) {
                        Node front = levelNode.poll();
                        front.data = levelData.pop();
                    }

                }
                // enqueue left child of the current node
                if (curr.left != null)
                    queue.add(curr.left);

                if (curr.right != null)
                    queue.add(curr.right);
            }
        }
    }
}
