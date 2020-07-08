package main.java.leetcode;

public class LCAOfDeepestLeaves {

    TreeNode ans = null;
    int maxDepth =0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root,0);
        return ans;
    }

    private int dfs(TreeNode node,int depth){
        if(node == null){
            maxDepth = Math.max(maxDepth,depth);
            return depth;
        }
        int left = dfs(node.left,depth+1);
        int right = dfs(node.right,depth+1);
        if(left == maxDepth && right==maxDepth){
            ans =node;
        }
        return Math.max(left,right);
    }

    public static void main(String[] args) {
        TreeNode root  = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        LCAOfDeepestLeaves lcaOfDeepestLeaves = new LCAOfDeepestLeaves();
        lcaOfDeepestLeaves.lcaDeepestLeaves(root);
    }

}
