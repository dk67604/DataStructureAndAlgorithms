package main.java.leetcode;

import java.util.Stack;

public class RecoverBinaryTree {
    private void swap(TreeNode a, TreeNode b ){
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode x=null,y=null,predecessor =null;
        while(!stack.isEmpty() || (root!=null)){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(predecessor!=null && root.val < predecessor.val){
                y = root;
                if(x==null) x = predecessor;
                else
                    break;
            }
            predecessor = root;
            root = root.right;
        }
        swap(x,y);

    }
    
    public static void main(String[] args) {
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(1);
		root.right=new TreeNode(4);
		root.right.left=new TreeNode(2);
		RecoverBinaryTree recoverBinaryTree=new RecoverBinaryTree();
		recoverBinaryTree.recoverTree(root);
	}
}
