package main.java.leetcode;

public class LongestUnivaluePath {

    public int longestUnivaluePath(TreeNode root) {
        int[] res = new int[1];
        if(root!=null) dfs(root,res);
        return res[0];
    }

    private int dfs(TreeNode node,int[] res){
        if(node == null) return 0;
        int left = dfs(node.left,res);
        int right = dfs(node.right,res);
        left = node.left!=null && node.left.val ==  node.val?left+1:0;
        right = node.right!=null && node.right.val == node.val?right+1:0;
        res[0] =Math.max(res[0],left+right);
        return Math.max(left,right);
    }
}
