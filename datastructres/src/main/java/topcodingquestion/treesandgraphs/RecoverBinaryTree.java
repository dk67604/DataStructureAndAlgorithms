package main.java.topcodingquestion.treesandgraphs;

import java.util.Stack;

public class RecoverBinaryTree {
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode x = null, y = null, predecessor = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (predecessor != null && root.val < predecessor.val) {
                y = root;
                if (x == null) x = predecessor;
                else
                    break;
            }
            predecessor = root;
            root = root.right;
        }
        swap(x, y);
    }

    private void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}
