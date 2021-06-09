package main.java.topcodingquestion.treesandgraphs;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class ConstructBinaryTreeFromInorderAndPostOrder {

    // Recursive function to perform inorder traversal on a given binary tree
    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    // Recursive function to perform postorder traversal on a given binary tree
    public static void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        int[] inorder = {4, 2, 1, 7, 5, 8, 3, 6};
        int[] postorder = {4, 2, 7, 8, 5, 6, 3, 1};
        ConstructBinaryTreeFromInorderAndPostOrder constructBinaryTreeFromInorderAndPostOrder =
                new ConstructBinaryTreeFromInorderAndPostOrder();
        TreeNode root = constructBinaryTreeFromInorderAndPostOrder.construct(inorder, postorder);
        inorderTraversal(root);
        System.out.println();
        postorderTraversal(root);
    }

    public TreeNode construct(int[] inorder, int[] postorder) {
        if (postorder.length == 0) return null;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        // initialize the stack of tree nodes
        Stack<TreeNode> stack = new Stack<>();
        int n = postorder.length;
        int value = postorder[n - 1];
        TreeNode root = new TreeNode(value);
        stack.push(root);

        // for all remaining values...
        for (int i = n - 2; i >= 0; i--) {
            // create a node
            value = postorder[i];
            TreeNode node = new TreeNode(value);

            if (map.get(value) > map.get(stack.peek().val)) {
                // the new node is on the right of the last node,
                // so it must be its right child (that's the way postorder works)
                stack.peek().right = node;
            } else {
                // the new node is on the left of the last node,
                // so it must be the left child of either the last node
                // or one of the last node's ancestors.
                // pop the stack until we either run out of ancestors
                // or the node at the top of the stack is to the left of the new node
                TreeNode parent = null;
                while (!stack.isEmpty() && map.get(value) < map.get(stack.peek().val)) {
                    parent = stack.pop();
                }
                parent.left = node;
            }
            stack.push(node);
        }

        return root;
    }
}
