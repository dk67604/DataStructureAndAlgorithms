package main.java.leetcode;

public class VerifyPreOrderSequenceBST {

    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE, i = -1;
        for (int p : preorder) {
            if (p < low)
                return false;
            while (i >= 0 && p > preorder[i])
                low = preorder[i--];
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
