package main.java.topcodingquestion.treesandgraphs;

import java.util.concurrent.atomic.AtomicInteger;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        AtomicInteger result = new AtomicInteger(Integer.MIN_VALUE);
        findMaxPathSum(root, result);
        return result.get();

    }

    public int findMaxPathSum(TreeNode node, AtomicInteger result) {
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
        max = Integer.max(max, node.val);
        max = Integer.max(max, node.val + left);
        max = Integer.max(max, node.val + right);
        max = Integer.max(max, node.val + left + right);
        result.set(max);
        // return the maximum path sum "starting" from the given node
        return Integer.max(node.val, node.val + Integer.max(left, right));
    }
}
