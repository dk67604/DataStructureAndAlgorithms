package main.java.topcodingquestion.treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BoundaryTraversal {
    LinkedList<Integer> boundaryElement = new LinkedList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) return new ArrayList<>();
        boundaryElement.add(root.val);
        //add left boundary elements(except leaf node)
        leftBoundary(root.left);
        // add leaf nodes
        if (!isLeaf(root)) {
            leafNodes(root);
        }
        //add right boundary(except leaf node)
        rightBoundary(root.right);
        return boundaryElement;


    }

    // Recursive function to print the left boundary of the given binary tree
    // in a top-down fashion, except for the leaf nodes
    private void leftBoundary(TreeNode root) {
        TreeNode node = root;
        while (node != null && !isLeaf(node)) {
            boundaryElement.addLast(node.val);
            // next process, the left child of `root` if it exists;
            // otherwise, move to the right child
            node = (node.left != null) ? node.left : node.right;
        }
    }

    // Recursive function to print the leaf nodes of the given
    // binary tree in an inorder fashion
    private void leafNodes(TreeNode root) {
        //base case
        if (root == null)
            return;
        leafNodes(root.left);
        if (isLeaf(root)) {
            boundaryElement.addLast(root.val);
        }
        leafNodes(root.right);

    }

    // Recursive function to print the right boundary of the given binary tree
    // in a bottom-up fashion, except for the leaf nodes
    private void rightBoundary(TreeNode root) {
        if (root == null || isLeaf(root)) {
            return;
        }
        rightBoundary(root.right != null ? root.right : root.left);
        boundaryElement.addLast(root.val);
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
