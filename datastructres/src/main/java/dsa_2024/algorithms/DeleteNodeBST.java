package main.java.dsa_2024.algorithms;

import main.java.dsa_2024.datastructures.TreeNode;

public class DeleteNodeBST {

    public TreeNode deleteNode(TreeNode root, int key){
        if(root == null) return null;

        if (key > root.val){
            root.right = deleteNode(root.right, key);
        }
        else if( key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else{
            if (root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                TreeNode minVal = findMin(root.right);
                root.val = minVal.val;
                root.right = deleteNode(root.right, minVal.val);
            }
        }
        return root;

    }

    private TreeNode findMin(TreeNode root){
        TreeNode current = root;
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }

}
