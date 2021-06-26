package main.java.topcodingquestion.treesandgraphs;

import java.util.concurrent.atomic.AtomicInteger;

public class LongestZigZagPathInABinaryTree {
    public int longestZigZag(TreeNode root) {
        if (root == null) return -1;
        AtomicInteger max = new AtomicInteger();
        max.set(Integer.MIN_VALUE);
        helper(root.right, 1, max, true);//go right
        helper(root.left, 1, max, false);
        return max.get();
    }

    private void helper(TreeNode node, int step, AtomicInteger max, boolean isRight) {
        if (node == null) return;
        max.set(Math.max(max.get(), step));
        if (isRight) {// if coming from right go left
            helper(node.left, step + 1, max, false);
            helper(node.right, 1, max, true);// try again from start
        } else {//else coming from left go to right
            helper(node.right, step + 1, max, true);
            helper(node.left, 1, max, false);// try again from start
        }
    }
}
