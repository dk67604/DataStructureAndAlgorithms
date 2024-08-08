package main.java.dsa_2024.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import main.java.dsa_2024.datastructures.TreeNode;

public class BinaryTreeInorder {

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node!=null) {
            if (node != null){
                stack.push(node);
                node = node.left;
            }
            else{
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }

}
