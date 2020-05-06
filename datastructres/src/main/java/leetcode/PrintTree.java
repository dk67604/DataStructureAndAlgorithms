package main.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintTree {

//    public List<List<String>> printTree(TreeNode root) {
//        List<List<String>> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//
//        int rows = getHeight(root);
//        int cols = (int)Math.pow(2, rows) - 1;
//        for (int i = 0; i < rows; i++) {
//            List<String> row = new ArrayList<>();
//            for (int j = 0; j < cols; j++) {
//                row.add("");
//            }
//            res.add(row);
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        Queue<int[]> indexQ = new LinkedList<>();
//        queue.offer(root);
//        indexQ.offer(new int[] { 0, cols - 1 });
//        int row = -1;
//        while (!queue.isEmpty()) {
//            row++;
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode cur = queue.poll();
//                int[] indices = indexQ.poll();
//
//                if (cur == null) {
//                    continue;
//                }
//
//                int left = indices[0];
//                int right = indices[1];
//                int mid = left + (right - left) / 2;
//                res.get(row).set(mid, String.valueOf(cur.val));
//
//                queue.offer(cur.left);
//                queue.offer(cur.right);
//                indexQ.offer(new int[] { left, mid - 1 });
//                indexQ.offer(new int[] { mid + 1, right });
//            }
//        }
//
//        return res;
//    }
//
//    private int getHeight(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
//    }


    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res=new ArrayList<>();
        if(root == null) return res;
        int rows=getHeight(root);
        int cols=(int)Math.pow(2,rows)-1;
        List<String> row_list=new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add("");
            }
            res.add(row);
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        Queue<int[]> indexQ=new LinkedList<>();
        indexQ.add(new int[]{0,cols-1});
        int row=-1;
        while(!queue.isEmpty()){
            row++;
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                int[] indices = indexQ.poll();
                if(curr==null) continue;
                int left = indices[0];
                int right = indices[1];
                int mid = left + (right-left)/2;
                res.get(row).set(mid,String.valueOf(curr.val));
                queue.offer(curr.left);
                queue.offer(curr.right);
                indexQ.offer(new int[] {left,mid-1});
                indexQ.offer(new int[] {mid+1,right});

            }

        }
        return res;
    }


    public int getHeight(TreeNode root){
        if (root==null) return 0;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.right=new TreeNode(4);

        PrintTree printTree=new PrintTree();
        printTree.printTree(root);
    }
}
