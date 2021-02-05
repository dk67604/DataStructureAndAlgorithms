package main.java.techiedelight.binarytree;

import java.util.concurrent.atomic.AtomicInteger;

/*
A simple solution is to traverse the tree and,
for every node, calculate the maximum sum
path starting from it and passing through its
left and right child. Keep track of the
maximum among all the maximum sum
paths found and return it after all nodes are
processed. The time complexity of this
solution is O(n ), where n is the total
number of nodes in the binary tree.
We can reduce the time complexity to linear
by traversing the tree in a bottom-up
manner. Each node returns the maximum
path sum “starting” at that node to its parent.
To ensure that the maximum path sum
“starts” at that node, at most, one child of the
node should be involved.
The maximum path sum passing “through” a node is the maximum of:
1. Node’s value.
2. Node’s value + maximum path sum “starting” from its left child.
3. Node’s value + maximum path sum “starting” from its right child.
4. Node’s value + maximum path sum “starting” from its left child + maximum path sum “starting” from its right
child.
 */
public class MaximumPathSumBinaryTree {

    public static void main(String[] args) {
        Node root = null;

        /* Construct the following tree
                1
              /   \
             /     \
            2      10
           / \    /  \
         -1  -4  -5   -6
             /   / \
            3   7   4
                 \
                 -2
        */

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(-1);
        root.left.right = new Node(-4);
        root.right.left = new Node(-5);
        root.right.right = new Node(-6);
        root.left.right.left = new Node(4);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(4);
        root.right.left.left.right = new Node(-2);

        AtomicInteger result = new AtomicInteger(Integer.MIN_VALUE);
        MaximumPathSumBinaryTree maximumPathSumBinaryTree = new MaximumPathSumBinaryTree();
        maximumPathSumBinaryTree.findMaxPathSum(root, result);
        System.out.println("The maximum path sum is " + result);
    }

    public int findMaxPathSum(Node node, AtomicInteger result) {
        //base case: empty tree
        if (node == null) {
            return 0;
        }
        // find maximum path sum "starting" from the left child
        int left = findMaxPathSum(node.left, result);
        // find maximum path sum "starting" from the right child
        int right = findMaxPathSum(node.right, result);
        // Try all possible combinations to get the optimal result
        int max = result.get();
        max = Integer.max(max, node.data);
        max = Integer.max(max, node.data + left);
        max = Integer.max(max, node.data + right);
        max = Integer.max(max, node.data + left + right);
        result.set(max);
        // return the maximum path sum "starting" from the given node
        return Integer.max(node.data, node.data + Integer.max(left, right));
    }
}
