package main.java.dsa_2024.algorithms;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : nums){
            sum += num;
            max = Math.max(sum, max);
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}
