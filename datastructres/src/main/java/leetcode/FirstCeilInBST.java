package main.java.leetcode;
/*
We have a binary search tree and a number N.
Our task is to find the greatest number in the binary search tree that is less than or equal to N.
Print the value of the element if it exists otherwise print -1.
 */
public class FirstCeilInBST {

    public int findMaxForN(TreeNode root,int N){
        //Base case
        if(root == null)
            return -1;
        if(root.val == N)
            return N;
        // If root's value is smaller, try in right
        // subtree
        else if(root.val < N){
            int k = findMaxForN(root.right,N);
            if(k == -1)
                return root.val;
            else
                return k;
        }

        // If root's key is greater, return value
        // from left subtree.
        else if(root.val >N)
            return findMaxForN(root.left,N);
        return -1;
    }
}
