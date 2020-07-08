package main.java.leetcode;

import java.util.Stack;

public class IncreaseBST {

    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode dummy = new TreeNode(0), p = dummy;
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode cur = stack.pop();
                root = cur.right;
                cur.left = null;
                p.right = cur;
                p = p.right;
            }
        }
        return dummy.right;
    }

    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode res = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return res;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(5);
        node.left=new TreeNode(3);
        node.right=new TreeNode(6);
        node.left.left=new TreeNode(2);
        node.left.left.left=new TreeNode(1);
        node.left.right= new TreeNode(4);
        node.right.right = new TreeNode(8);
        node.right.right.left = new TreeNode(7);
        node.right.right.right =new TreeNode(9);
        IncreaseBST increaseBST = new IncreaseBST();
        increaseBST.increasingBST(node);


    }
}
