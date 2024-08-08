package main.java.dsa_2024.algorithms;

import java.util.*;

import main.java.dsa_2024.datastructures.TreeNode;

public class LevelOrderTravesal {

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i< len; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left !=null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }

}
