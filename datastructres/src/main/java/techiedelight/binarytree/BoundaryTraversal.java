package main.java.techiedelight.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
The idea is to split the problem into 3 parts:
- Print the left boundary in top-down fashion
- Print the leaf nodes in the same order as in the inorder traversal
- Print the right boundary in bottom-up fashion
 */
public class BoundaryTraversal {
    LinkedList<Integer> boundaryElement = new LinkedList<>();

    public static void main(String[] args) {
        // construct a binary tree as per the above diagram
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.right = new Node(10);
        root.right.right.left = new Node(11);
        root.left.left.right.left = new Node(12);
        root.left.left.right.right = new Node(13);
        root.right.right.left.left = new Node(14);
        BoundaryTraversal boundaryTraversal = new BoundaryTraversal();
        List<Integer> boundaryElement = boundaryTraversal.performBoundaryTraversal(root);
        System.out.println(boundaryElement);
    }

    // Recursive function to print the left boundary of the given binary tree
    // in a top-down fashion, except for the leaf nodes
    private void leftBoundary(Node root) {
        Node node = root;
        while (!node.isLeaf()) {
            boundaryElement.addLast(node.data);
            // next process, the left child of `root` if it exists;
            // otherwise, move to the right child
            node = (node.left != null) ? node.left : node.right;
        }
    }

    // Recursive function to print the right boundary of the given binary tree
    // in a bottom-up fashion, except for the leaf nodes
    private void rightBoundary(Node root) {
        // base case: root is empty, or root is a leaf node
        if (root == null || root.isLeaf())
            return;
        // recur for the right child of `root` if it exists;
        // otherwise, recur for the left child
        rightBoundary(root.right != null ? root.right : root.left);
        boundaryElement.addLast(root.data);
    }

    // Recursive function to print the leaf nodes of the given
    // binary tree in an inorder fashion
    private void leafNodes(Node root) {
        //base case
        if (root == null)
            return;
        // recur for the left subtree
        leafNodes(root.left);
        if (root.isLeaf())
            boundaryElement.addLast(root.data);
        //recur for right
        leafNodes(root.right);
    }

    public List<Integer> performBoundaryTraversal(Node root) {
        //base case
        if (root == null)
            return new ArrayList<>();
        boundaryElement.addLast(root.data);
        //add left boundary elements(except leaf node)
        leftBoundary(root.left);
        // add leaf nodes
        if (!root.isLeaf())
            leafNodes(root);
        //add right boundary(except leaf node)
        rightBoundary(root.right);
        return boundaryElement;
    }
}
