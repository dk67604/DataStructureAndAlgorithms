package main.java.leetcode;

import java.util.Stack;

public class KthSmallestInBST {

    //Use inorder traversal, in iterative we don't need to create
    // the full inorder traversal, one could stop at kth smallest
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (true){
            // left
            while (root!=null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            //root
            if(--k==0) return root.val;
            //right
            root = root.right;
        }

    }
}
