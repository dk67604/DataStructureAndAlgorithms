package main.java.leetcode;

public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0) return null;

        TreeNode head =  constructBST(nums, 0, nums.length-1);
        return head;
    }

    private TreeNode constructBST(int[] nums, int low, int high){
        if(low>high){
            return null;
        }
        int mid =  low + (high-low) / 2 ;
        TreeNode current = new TreeNode(nums[mid]);
        current.left = constructBST(nums, low, mid-1);
        current.right = constructBST(nums, mid+1, high);
        return current;
    }
    public  Float method(){
        return null;
    }
    public static void main(String[] args) {
        int [] nums={-10,-3,0,5,9};
        ConvertSortedArrayToBST convertSortedArrayToBST=new ConvertSortedArrayToBST();
        convertSortedArrayToBST.sortedArrayToBST(nums);



    }
}
