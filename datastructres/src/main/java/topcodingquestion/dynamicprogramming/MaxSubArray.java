package main.java.topcodingquestion.dynamicprogramming;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int maxCurrent = nums[0];
        int maxGlobal = nums[0];
        for(int i =1;i< nums.length;i++){
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
            maxGlobal = Math.max(maxCurrent,maxGlobal);
        }
        return maxGlobal;
    }
}
