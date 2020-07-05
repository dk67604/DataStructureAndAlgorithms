package main.java.leetcode;

/*
Given a Binary Search Tree and a number N,
the task is to find the smallest number
in the binary search tree that is greater than or equal to N.
 */
public class FirstFloorInBST {

    public int firstMinForN(TreeNode root,int N){
        // If leaf node reached and is smaller than N
        if(root.left == null && root.right == null && root.val<N ) return -1;
        // If node's value is greater than N and left value
        // is null or smaller then return the node value
        if((root.val >=N && root.left ==null)||
                (root.val>=N && root.left.val < N))
            return root.val;

        // if node value is smaller than N search in the
        // right subtree
        if(root.val <=N)
            return firstMinForN(root.right,N);

        // if node value is greater than N search in the
        // left subtree
        else {
           return firstMinForN(root.left,N);
        }

    }

}
