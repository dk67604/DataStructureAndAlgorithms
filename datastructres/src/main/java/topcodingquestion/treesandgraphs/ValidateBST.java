package main.java.topcodingquestion.treesandgraphs;

import java.util.Stack;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && root.val <= prev.val) return false;
            prev = root;
            root = root.right;
        }
        return true;
    }
}
