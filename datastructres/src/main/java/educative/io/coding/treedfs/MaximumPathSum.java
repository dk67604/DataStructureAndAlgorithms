package main.java.educative.io.coding.treedfs;

public class MaximumPathSum {

    public static int findMaximumPathSum(TreeNode root) {
        int[] ans = {Integer.MIN_VALUE};
        maximumPathSumRecursive(root,ans);
        return ans[0];
    }
    private static int maximumPathSumRecursive(TreeNode currentNode,int[] ans ){
        if(currentNode == null){
            return 0;
        }
        int maxPathSumFromLeft = maximumPathSumRecursive(currentNode.left,ans);
        int maxPathSumFromRight = maximumPathSumRecursive(currentNode.right,ans);
        // ignore paths with negative sums, since we need to find the maximum sum we should
        // ignore any path which has an overall negative sum.
        maxPathSumFromLeft = Math.max(maxPathSumFromLeft,0);
        maxPathSumFromRight = Math.max(maxPathSumFromRight,0);
        // maximum path sum at the current node will be equal to the sum from the left subtree +
        // the sum from right subtree + val of current node
        int localMaximumSum = maxPathSumFromLeft + maxPathSumFromRight + currentNode.val;
        // update the global maximum sum
        ans[0] = Math.max(ans[0],localMaximumSum);
        // maximum sum of any path from the current node will be equal to the maximum of
        // the sums from left or right subtrees plus the value of the current node
        return Math.max(maxPathSumFromLeft,maxPathSumFromRight) + currentNode.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    }
}
