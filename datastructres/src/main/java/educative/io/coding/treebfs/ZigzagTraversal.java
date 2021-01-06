package main.java.educative.io.coding.treebfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        int currentLevel =0;
        queue.add(root);
        while (!queue.isEmpty()){
            currentLevel+=1;
            List<Integer> currentLevelList = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i< size;i++){
                TreeNode node = queue.poll();

                if( currentLevel%2 !=0 ){
                    currentLevelList.add(node.val);
                }
                else if(currentLevel%2 == 0){
                    currentLevelList.add(0,node.val);
                }
                if(node.left!=null ) queue.add(node.left);
                if(node.right!=null ) queue.add(node.right);

            }
            result.add(currentLevelList);
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigzagTraversal.traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}
