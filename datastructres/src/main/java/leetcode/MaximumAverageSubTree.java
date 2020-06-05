package main.java.leetcode;

import java.util.Arrays;
import java.util.List;

public class MaximumAverageSubTree {

    class Node{
        int val;
        List<Node> children;
        public Node(int  val){
            this.val = val;
        }
    }

    public double maximumAverageSubtree(TreeNode root) {

        return dfs(root)[2];
    }

    public double[] dfs(TreeNode node){
        if(node == null){
            return new double[]{0,0,0};
        }
        double[] l = dfs(node.left);
        double[] r = dfs(node.right);
        double sum = l[0]+r[0]+node.val;
        double count = l[1] + r[1]+1;
        double avg = 1.0 *(sum/count);
        double child = Math.max(l[2],r[2]); // leaf of subtree average is equal to leaf value
        double maxOfThree = Math.max(child,avg);
        return new double[]{sum,count,maxOfThree};

    }

    /*
  Given an N-ary tree, find the subtree with the maximum average. Return the root of the subtree.
A subtree of a tree is the node which have at least 1 child plus all its descendants. The average value of a subtree is the sum of its values, divided by the number of nodes.

Example 1:

Input:
		 20
	   /   \
	 12     18
  /  |  \   / \
11   2   3 15  8

Output: 18
Explanation:
There are 3 nodes which have children in this tree:
12 => (11 + 2 + 3 + 12) / 4 = 7
18 => (18 + 15 + 8) / 3 = 13.67
20 => (12 + 11 + 2 + 3 + 18 + 15 + 8 + 20) / 8 = 11.125

18 has the maximum average so output 18.

     */
    Node maxNode;
    double max;
    public Node getMaximumAverage(Node root) {
        maxNode = null;
        max = Double.MIN_VALUE;
        helper(root);
        return maxNode;
    }

    private double[] helper(Node node){
        if (node == null) return new double[]{0,0};
        double count =1;
        double sum = node.val;
        if(node.children!=null){
            for (Node child:node.children){
                double [] curr = helper(child);
                sum+=curr[0];
                count+=curr[1];
            }
        }
        double average = sum/count;

        if(count>1&& average> max){
            max =average;
            maxNode = node;
        }
        return new double[]{sum,count};
    }
    public void test(){
        Node left = new Node(12);
        left.children = Arrays.asList(new Node(11), new Node(2), new Node(3));

        Node right = new Node(18);
        right.children = Arrays.asList(new Node(15), new Node(8));

        Node root = new Node(20);
        root.children = Arrays.asList(left, right);
        Node maxNode = getMaximumAverage(root);
        System.out.println(maxNode.val);
    }



    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(1);
        MaximumAverageSubTree maximumAverageSubTree = new MaximumAverageSubTree();
        System.out.println(maximumAverageSubTree.maximumAverageSubtree(treeNode));
        maximumAverageSubTree.test();

    }
}
