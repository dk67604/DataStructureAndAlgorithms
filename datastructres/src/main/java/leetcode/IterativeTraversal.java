package main.java.leetcode;

import java.util.*;

public class IterativeTraversal {

    public List<Integer> traversePreDFS(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return res;
    }

    public List<Integer> traverseInorder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (true){
            if(node!=null){
                stack.push(node);
                node = node.left;
            }else {
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pop();
                if(node!=null){
                    res.add(node.val);
                    node = node.right;
                }

            }
        }
        return res;
    }

    public List<Integer> traversepostOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while(current != null || !stack.isEmpty()){
            if(current != null){
                stack.push(current);
                current = current.left;
            }else{
                TreeNode temp = stack.peek().right;
                //process left tree
                if (temp == null) {
                    temp = stack.pop();
                    res.add(temp.val);
                    //Check to process the root node of subtree
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        res.add(temp.val);
                    }

                } else {
                    current = temp;//move to right tree
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(2);
        IterativeTraversal iterativeTraversal = new IterativeTraversal();
        System.out.println("<<<<<<Preorder>>>>>>>");

        List<Integer> list = iterativeTraversal.traversePreDFS(treeNode);
        for(Integer e:list){
            System.out.println(e);
        }
        System.out.println("<<<<<<Inorder>>>>>>>");
        List<Integer> listIn = iterativeTraversal.traverseInorder(treeNode);
        for(Integer e:listIn){
            System.out.println(e);
        }

        System.out.println("<<<<<<Postorder>>>>>>>");

        List<Integer> listPost = iterativeTraversal.traversepostOrder(treeNode);
        for(Integer e:listPost){
            System.out.println(e);
        }
    }
}
