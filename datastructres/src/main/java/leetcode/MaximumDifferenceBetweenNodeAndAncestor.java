package main.java.leetcode;

public class MaximumDifferenceBetweenNodeAndAncestor {

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root,root.val,root.val);
    }

    //We pass the minimum and maximum values to the children,
    //At the leaf node, we return max - min through the path from the root to the leaf.
    private int dfs(TreeNode node,int max,int min){
        if (node == null) return max -min;
        max = Math.max(max,node.val);
        min = Math.min(min,node.val);
        return Math.max(dfs(node.left,max,min),dfs(node.right,max,min));
    }
}
