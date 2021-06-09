package main.java.topcodingquestion.treesandgraphs;

import java.util.Stack;

public class ConstructBSTFromPreorder {
    // Recursive function to perform inorder traversal on a given binary tree
    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        ConstructBSTFromPreorder constructBSTFromPreorder = new ConstructBSTFromPreorder();
        TreeNode root = constructBSTFromPreorder.construct(preorder);
        inorderTraversal(root);
    }

    public TreeNode construct(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = stack.peek();
            TreeNode child = new TreeNode(preorder[i]);
            //Adjust parent
            while (!stack.isEmpty() && stack.peek().val < child.val) {
                node = stack.pop();
            }
            if (node.val < child.val) node.right = child;
            else node.left = child;
            stack.push(child);
        }

        return root;
    }
}
