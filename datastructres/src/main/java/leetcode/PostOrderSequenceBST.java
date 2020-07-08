package main.java.leetcode;

public class PostOrderSequenceBST {

    public boolean postOrderSequence(int[] sequence, int start,int end){
        if(sequence == null || sequence.length<=0) return false;
        int root = sequence[end-1];

        //nodes in left sub-tree are less than the root
        int i =0;
        for (;i<end-1;++i){
            if(sequence[i]>root)
                break;
        }
        int j=i;
        // nodes in right sub-tree are greater than root node
        for (;j<end-1;++j) {
            if (sequence[j] < root)
                return false;
        }
        boolean left = true;
        if(i>0)
            left = postOrderSequence(sequence,start,i);
        boolean right = true;
        if(j<end-1)
            right = postOrderSequence(sequence,i+1,end);

        return (left && right);

    }

    public  boolean verifyPostOrder(int[] postoder){
        int high = Integer.MAX_VALUE;

        int i=postoder.length;
        for (int j = postoder.length-1 ;j>=0;j--){
            if(postoder[j]>high) return false;
            while (i<=postoder.length-1 && postoder[j]<postoder[i]){
                high = postoder[i++];
            }
            postoder[--i] = postoder[j];
        }
        return true;
    }

    public static void main(String[] args) {
        PostOrderSequenceBST postOrderSequenceBST = new PostOrderSequenceBST();
        int[] nums = new int[]{5, 7, 6, 9, 11, 10, 8};
        int[] nums1 = new int[]{7, 4, 6, 5};

        int start = 0;
        int end = nums1.length;
        System.out.println(postOrderSequenceBST.postOrderSequence(nums,start,end));
        System.out.println(postOrderSequenceBST.verifyPostOrder(nums));
    }
}
