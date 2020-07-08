package main.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SwapNodesAlgorithm {
    static class Node{
        int index;
        int depth;
        Node left;
        Node right;
        public Node(int index,int depth){
            this.index=index;
            this.depth = depth;
        }
    }

    private static void swapInOrder(Node curr,int depth,int k){
        if(curr == null) return;
        swapInOrder(curr.left,depth+1,k);
        swapInOrder(curr.right,depth+1,k);
        if(depth>=k && depth%k==0){
            Node temp = curr.left;
            curr.left = curr.right;
            curr.right =temp;

        }
    }


    /*
     * Complete the swapNodes function below.
     */
    public static int[][] swapNodes(int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         */
        Node root = new Node(1,1);

        root = buildTree(indexes,root);
        int[][] result = new int[queries.length][indexes.length];
        for (int i = 0 ; i<queries.length;i++){
                swapInOrder(root,1,queries[i]);
                List<Integer> res = new ArrayList<>();
                printInorder(root,res);
                result[i] = res.stream().mapToInt(r->r).toArray();
        }

        return result;

    }

    private static void printInorder(Node curr, List<Integer> result){
        if(curr == null) return;
        printInorder(curr.left,result);
        result.add(curr.index);
        printInorder(curr.right,result);
    }

    private static Node buildTree(int[][] indexes,Node root){
        int numOfNodes = indexes.length;
        Queue<Node> queue = new LinkedList<>();
        Node curr = root;
        queue.offer(curr);
        int N =0;
        while (N < numOfNodes){
            curr = queue.poll();
            int leftData = indexes[N][0];
            int rightData = indexes[N][1];
            curr.left = (leftData == -1)?null:new Node(leftData,curr.depth+1);
            curr.right = (rightData == -1)?null:new Node(rightData,curr.depth+1);
            if(curr.left!=null && curr.left.index!=-1)
                queue.offer(curr.left);
            if(curr.right!=null&& curr.right.index!=-1)
                queue.offer(curr.right);
            N++;
        }
        return root;

    }

    public static void main(String[] args) {
        int[][] indexes = {{2,3}};
        int[] queries = {1,1};
        swapNodes(indexes,queries);
    }

}
