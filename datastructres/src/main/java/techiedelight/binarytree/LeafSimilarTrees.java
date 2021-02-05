package main.java.techiedelight.binarytree;

import java.util.Stack;

public class LeafSimilarTrees {
    public static void main(String[] args) {
        Node x = new Node(1);
        x.left = new Node(2);
        x.right = new Node(3);
        x.left.left = new Node(4);
        x.left.right = new Node(5);
        x.right.left = new Node(6);

        Node y = new Node(1);
        y.left = new Node(2);
        y.right = new Node(3);
        y.left.right = new Node(4);
        y.right.left = new Node(5);
        y.right.right = new Node(6);
        LeafSimilarTrees leafSimilarTrees = new LeafSimilarTrees();
        boolean isSame = leafSimilarTrees.isLeafTraversalSame(x, y);
        if (isSame) {
            System.out.println("The tree traversals are the same");
        } else {
            System.out.println("The tree traversals are different");
        }
    }

    public boolean isLeafTraversalSame(Node x, Node y) {
        //create two empty stack
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        // push the root node of the first and second tree into the first and
        // second stack, respectively
        if (x != null && y != null) {
            s1.push(x);
            s2.push(y);
        }
        // loop till a stack becomes empty
        while (!s1.isEmpty() && !s2.isEmpty()) {
            // get the next leaf in a preorder sequence of the first tree
            Node xLeaf = dfs(s1);
            // get the next leaf in a preorder sequence of the second tree
            Node yLeaf = dfs(s2);
            if (xLeaf.data != yLeaf.data) {
                return false;
            }
        }
        // return true only if both stacks are empty at this point;
        // if any of the stacks is not empty, that means some tree
        // contains more leaf nodes
        return s1.isEmpty() && s2.isEmpty();

    }

    // Utility function to return the next leaf node in a preorder sequence
    private Node dfs(Stack<Node> s) {
        while (true) {
            Node node = s.pop();
            if (node.right != null) s.push(node.right);
            if (node.left != null) s.push(node.left);
            if (node.isLeaf()) return node;
        }
    }
}
