package main.java.leetcode;

public class MaximumProductArray {

	public int[] productExceptSelf(int[] nums) {
        int[] res=new int[nums.length];
        res[0]=1;
        for(int i=1;i<nums.length;i++) {
        	res[i]=nums[i-1]*res[i-1];
        }
        int right=nums[nums.length-1];
        for(int i=nums.length-1;i>=0;i--) {
        	res[i]*=right;
        	right*=nums[i];
        }
        return res;
    }
}
