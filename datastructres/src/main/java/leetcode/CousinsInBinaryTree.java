package main.java.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()){
            boolean isXExist = false;
            boolean isYExist = false;
            int size = queue.size();
            for (int i =0 ;i <size;i++){
                TreeNode curr = queue.poll();
                if(curr.val == x) isXExist =true;
                if(curr.val == y) isYExist =true;

                // make ensure both x and y aren't sibling
                if(curr.left!=null && curr.right!=null){
                    if(curr.left.val == x  && curr.right.val ==y){
                        return false;
                    }
                    if (curr.left.val == y && curr.right.val ==x){
                        return false;
                    }

                }
                if(curr.left!=null)
                    queue.offer(curr.left);
                if(curr.right!=null)
                    queue.offer(curr.right);

            }
            if(isXExist && isYExist) return true;
        }

        return false;
    }



}
