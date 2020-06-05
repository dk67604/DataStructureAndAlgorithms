package main.java.leetcode;

public class LargestBSTSubTree {


    private class LBST {
        private boolean isBst;
        private int min, max, nodesNum;
        private LBST left, right;

        public LBST(boolean isBst, int min, int max, int nodesNum) {
            this.isBst = isBst;
            this.min = min;
            this.max = max;
            this.nodesNum = nodesNum;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        LBST node = buildLBST(root);
        return node.nodesNum;
    }

    private LBST buildLBST(TreeNode root) {
        if (root == null) return new LBST(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        LBST left = buildLBST(root.left);
        LBST right = buildLBST(root.right);
        if (left.isBst && right.isBst && left.max < root.val && right.min > root.val) {
            return new LBST(true, Math.min(left.min, root.val), Math.max(right.max, root.val), left.nodesNum + right.nodesNum + 1);
        } else {
            return new LBST(false, root.val, root.val, Math.max(left.nodesNum, right.nodesNum));
        }
    }
}