package main.java.leetcode;

/*
Given a node in a binary search tree, find the in-order successor of that node in the BST.

If that node has no in-order successor, return null.

The successor of a node is the node with the smallest key greater than node.val.

You will have direct access to the node but not to the root of the tree. Each node will have a reference to its parent node. Below is the definition for Node:

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}
 */
public class InorderSuccessorInBST {
    public Node inorderSuccessor(Node node) {
        if (node == null)
            return null;
        // the successor is somewhere lower in the right subtree
        if (node.right != null) {
            node = node.right;
            while (node.left != null) node = node.left; // continue left till you can
            return node;
        }
        //the successor is somewhere upper in the tree
        // go up till the node that is left child of parent, then return the parent
        while (node.parent != null && node == node.parent.right) node = node.parent;
        return node.parent;

    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
}
