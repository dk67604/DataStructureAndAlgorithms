package main.java.dsa_2024.algorithms;

import main.java.dsa_2024.datastructures.TreeNode;

public class SearchinBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null){
            return root;
        }
        if (root.val == val){
            return root;
        }
        return val<root.val? searchBST(root.left, val): searchBST(root.right, val);
    }

}
