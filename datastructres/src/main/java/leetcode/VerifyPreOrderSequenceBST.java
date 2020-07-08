package main.java.leetcode;

public class VerifyPreOrderSequenceBST {

    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;// lower bound in right subtree
        int i=-1;
        for(int p: preorder){
            //Violate condition for BST having greater value in left subtree
            if(p<low) return false;
            //keep updating low value until we find current element is less that root
            // we are in right sub tree
            while(i>=0 && p>preorder[i]){
                //lower bound in right subtree
                low = preorder[i--];
            }
            //keep on going in left subtree
            preorder[++i] = p;
        }

        return true;

    }


    public static void main(String[] args) {
        int[] preorder = new int[]{5,2,6,1,3};
        VerifyPreOrderSequenceBST verifyPreOrderSequenceBST= new VerifyPreOrderSequenceBST();
        System.out.println(verifyPreOrderSequenceBST.verifyPreorder(preorder));
    }
}
