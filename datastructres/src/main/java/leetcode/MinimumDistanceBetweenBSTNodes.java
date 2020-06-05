package main.java.leetcode;

import java.util.Stack;

public class MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        Integer[] res = new Integer[2];
        res[1] = Integer.MAX_VALUE;
        dfs(root,res);
        return res[1];
    }

    public void dfs(TreeNode node,Integer[] res) {
        if (node == null) return;
        dfs(node.left,res);
        if (res[0] != null)
            res[1] = Math.min(res[1], node.val - res[0]);
        res[0] = node.val;
        dfs(node.right,res);
    }




    public int iterative(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        int minDiff = Integer.MAX_VALUE;
        while (!stack.isEmpty() || root!=null){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev!=null){
                minDiff = Math.min(minDiff,root.val-prev.val);
            }
            prev = root;
            root = root.right;
        }
        return minDiff;
    }



    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(27);
        treeNode.right = new TreeNode(34);
        treeNode.right.right = new TreeNode(58);
        treeNode.right.right.left = new TreeNode(50);
        treeNode.right.right.left.left = new TreeNode(44);
        MinimumDistanceBetweenBSTNodes minimumDistanceBetweenBSTNodes = new MinimumDistanceBetweenBSTNodes();
        System.out.println(minimumDistanceBetweenBSTNodes.minDiffInBST(treeNode));
    }
}
