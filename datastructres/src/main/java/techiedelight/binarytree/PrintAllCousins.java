package main.java.techiedelight.binarytree;

import main.java.leetcode.TreeNode;

public class PrintAllCousins {
    private int findLevel(TreeNode root, TreeNode node, int level) {
        if (root == null) return Integer.MIN_VALUE;
        if (root == node) return level;
        int left = findLevel(root.left, node, level + 1);
        if (left != Integer.MIN_VALUE) {
            return left;
        }
        return findLevel(root.right, node, level + 1);
    }

}
