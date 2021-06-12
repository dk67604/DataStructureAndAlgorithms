package main.java.topcodingquestion.treesandgraphs;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextPointerInEachNodeII {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        Node currentNode, prevNode = null;
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            if (currentNode == null) {
                if (!queue.isEmpty()) queue.add(null);
                prevNode = null;
                continue;
            }
            if (prevNode != null) {
                prevNode.next = currentNode;
            }
            prevNode = currentNode;
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return root;
    }
}
