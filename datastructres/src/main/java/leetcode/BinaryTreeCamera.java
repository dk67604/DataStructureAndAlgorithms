package main.java.leetcode;

import java.util.HashSet;
import java.util.Set;

public class BinaryTreeCamera {
    int ans;
    Set<TreeNode> covered;
    public int minCameraCover2(TreeNode root) {
        ans = 0;
        covered = new HashSet();
        covered.add(null);

        dfs(root, null);
        return ans;
    }

    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            dfs(node.left, node);
            dfs(node.right, node);

            if (par == null && !covered.contains(node) ||
                    !covered.contains(node.left) ||
                    !covered.contains(node.right)) {
                ans++;
                covered.add(node);
                covered.add(par);
                covered.add(node.left);
                covered.add(node.right);
            }
        }
    }

    private int helper(TreeNode node,int[] ans){
        if (node == null) return 2; // return 2 if it's covered and without a camera on this node
        int left = helper(node.left,ans);
        int right = helper(node.right,ans);
        if(left == 0 || right == 0){
            ans[0]++;
            return 1; // return 1 if it's parent of a leaf, with a camera on this node
        }
        return left == 1 || right == 1? 2: 0; //return 0 if there is a leaf node

    }
    public int minCameraCover(TreeNode root) {
        int[] ans = new int[1];
        if(root == null || (root.left == null && root.right ==null))return 1;

        return (helper(root, ans) < 1?1:0)+ans[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        BinaryTreeCamera binaryTreeCamera = new BinaryTreeCamera();
        System.out.println(binaryTreeCamera.minCameraCover(root));
    }
}
