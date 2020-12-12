package main.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftView {
    public List<Integer> leftViewTree(TreeNode root){
        List<Integer> res = new ArrayList<>();
        int[] l = new int[1];
        helper(root,1,res,l);
        return res;
    }

    public void helper(TreeNode node,int level,List<Integer> res,int[] l){
        if(node == null) return;
        if(l[0]<level){
            res.add(node.val);
            l[0]=level;
        }
        helper(node.left,level+1,res,l);
        helper(node.right,level+1,res,l);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(20);
        node.left = new TreeNode(15);
        node.right = new TreeNode(25);
//        node.left.left = new TreeNode(12);
        node.left.right = new TreeNode(18);
        node.right.left = new TreeNode(22);
        node.right.right = new TreeNode(28);
        LeftView leftView = new LeftView();
        List<Integer> res = leftView.leftViewTree(node);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
