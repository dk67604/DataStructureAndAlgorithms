package main.java.leetcode;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DeleteNodeAndReturnForest {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for(int d:to_delete){
            set.add(d);
        }
        List<TreeNode> res = new ArrayList<>();
        if(!set.contains(root.val)) res.add(root);
        helper(root,res,set);
        return res;
    }


    private TreeNode helper(TreeNode node,List<TreeNode> res,Set<Integer> set){
        if(node == null) return null;
        node.left = helper(node.left,res,set);
        node.right = helper(node.right,res,set);
        if(set.contains(node.val)){
            if(node.left!=null) res.add(node.left);
            if(node.right!=null)res.add(node.right);
            return null;
        }
        return node;

    }
}
