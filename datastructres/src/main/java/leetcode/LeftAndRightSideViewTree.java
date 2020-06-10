package main.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftAndRightSideViewTree {

    public void printLeftNRightViewOfBT(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode LS = new TreeNode(-1);
        queue.offer(node);
        queue.offer(LS);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        left.add(node.val);
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(!queue.isEmpty() && curr.val == LS.val){
                left.add(queue.peek().val);
                queue.offer(LS);
            }
            if(!queue.isEmpty() && queue.peek().val == LS.val){
                right.add(curr.val);
            }
            if(curr.left!=null) queue.offer(curr.left);
            if(curr.right!=null) queue.offer(curr.right);
        }

        for (int l:left){
            System.out.print(l+",");
        }
        System.out.println();
        for (int r:right){
            System.out.print(r+",");
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(20);
        node.left = new TreeNode(15);
        node.right = new TreeNode(25);
        node.left.left = new TreeNode(12);
        node.left.right = new TreeNode(18);
        node.right.left = new TreeNode(22);
        node.right.right = new TreeNode(28);
        LeftAndRightSideViewTree leftAndRightSideViewTree = new LeftAndRightSideViewTree();
       leftAndRightSideViewTree.printLeftNRightViewOfBT(node);
    }
}
