package main.java.ctci.treeandgraph;

import main.java.datastructure.TreeNode;

public class MinimalTree {
    public static void main(String[] args) {
//        int [] arrA = {2,3,6,7,8,9,12,15,16,18,20};
        int[] arrA = {1, 2, 3, 4, 5};
        MinimalTree s = new MinimalTree();
        TreeNode x = s.convert(arrA, 0, arrA.length - 1);
        System.out.println("Tree Display : ");
        s.displayTree(x);
    }

    public TreeNode convert(int[] arrA, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        if ((start + end) % 2 == 1) ++mid;
        TreeNode root = new TreeNode(arrA[mid]);
        root.left = convert(arrA, start, mid - 1);
        root.right = convert(arrA, mid + 1, end);
        return root;
    }

    public void displayTree(TreeNode root) {
        if (root != null) {
            displayTree(root.left);
            System.out.print(" " + root.val);
            displayTree(root.right);
        }
    }
}



