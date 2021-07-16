package main.java.topcodingquestion.treesandgraphs;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = {1};
        helper(root, max);
        return max[0] - 1;
    }

    private int helper(TreeNode node, int[] max) {
        if (node == null) return 0;
        int left = helper(node.left, max);
        int right = helper(node.right, max);
        max[0] = Math.max(max[0], left + right + 1);
        return Math.max(left, right) + 1;
    }
}
