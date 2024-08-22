package main.java.dsa_2024.algorithms;

import java.util.Stack;

import main.java.dsa_2024.datastructures.TreeNode;

public class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root){
        stack = new Stack<>();
        push(root);
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }

    public int next(){
        TreeNode tmp = stack.pop();
        push(tmp.right);
        return tmp.val;
    }

    public void push(TreeNode node){
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

}
