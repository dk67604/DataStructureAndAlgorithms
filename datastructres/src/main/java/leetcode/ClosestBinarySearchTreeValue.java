package main.java.leetcode;

public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int curr = root.val;
        while (root!=null){
            if(Math.abs(curr-target) > Math.abs(root.val - target)){
                curr = root.val;
            }
            root = root.val<target?root.right:root.left;
        }
        return curr;
    }
}
