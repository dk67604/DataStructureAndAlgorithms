package main.java.techiedelight.binarytree;

import java.util.concurrent.atomic.AtomicInteger;

//Find Maximum Difference Between a Node and its Descendants in a Binary Tree
public class MaximumDifferenceBetweenANodeAndDesc {

    public static int maxDifference(Node root, AtomicInteger diff) {
        // base case: if the tree is empty, return infinity
        if (root == null)
            return Integer.MAX_VALUE;
        //recur for the left and right subtree
        int left = maxDifference(root.left, diff);
        int right = maxDifference(root.right, diff);
        // find the maximum difference between the current node and its descendants
        int d = root.data - Math.min(left, right);
        // update the maximum difference found so far if required
        diff.set(Math.max(diff.get(), d));
        // For the difference to be maximum, the function should return
        // a minimum value among all subtree nodes
        return Math.min(Math.min(left, right), root.data);

    }

    // Find the maximum difference between a node and its descendants in a binary tree
    public static int maxDifference(Node root) {
        // using `AtomicInteger` to get the result since `Integer` is passed by value
        // in Java
        AtomicInteger diff = new AtomicInteger(Integer.MIN_VALUE);

        maxDifference(root, diff);

        return diff.get();
    }

    public static void main(String[] args) {
        /* Construct the following tree
                  6
                /   \
               /     \
              3       8
                    /   \
                   /     \
                  2       4
                /   \
               /     \
              1       7
        */

        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.right.left = new Node(2);
        root.right.right = new Node(4);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(7);

        System.out.print(maxDifference(root));
    }
}
