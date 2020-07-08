package main.java.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ConstructBinarySearchTreeFromPreoderTraversal {

    //Using recursion
    public TreeNode bstFromPreorder(int[] preorder){
        int[] idx = new int[1];
        return helper(idx,preorder,preorder.length,Integer.MIN_VALUE,Integer.MAX_VALUE);

    }

    private TreeNode helper(int[] idx,int[] preorder,int length,int start,int upper){
        if(idx[0] == length || preorder[idx[0]] < start || preorder[idx[0]]>upper) return null;
        int val = preorder[idx[0]];
        idx[0]++;
        TreeNode node = new TreeNode(val);
        node.left = helper(idx,preorder,length,start,val);
        node.right = helper(idx,preorder,length,val,upper);
        return node;
    }

    //Using Iterative
    public TreeNode bstFromPreorderUsingStack(int[] preorder) {
        int n = preorder.length;
        if(n == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        for (int i =1;i<n;i++){
            TreeNode node = stack.peek();
            TreeNode child = new TreeNode(preorder[i]);
            //Adjust parent
            while (!stack.isEmpty() && stack.peek().val < child.val){
                node =stack.pop();
            }
            //Use BST condition to create parent child relation
            if(node.val < child.val) node.right = child;
            else node.left = child;
            stack.push(child);
        }
        return root;
    }

    public static void main(String[] args) {
        int [] preorder = {8,5,1,7,10,12};
        ConstructBinarySearchTreeFromPreoderTraversal constructBinarySearchTreeFromPreoderTraversal = new ConstructBinarySearchTreeFromPreoderTraversal();
       constructBinarySearchTreeFromPreoderTraversal.bstFromPreorderUsingStack(preorder);

    }


}
