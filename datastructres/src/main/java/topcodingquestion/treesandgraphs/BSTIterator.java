package main.java.topcodingquestion.treesandgraphs;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        push(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode temp = stack.pop();
        push(temp.right);
        return temp.val;
    }

    public void push(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
