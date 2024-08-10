package main.java.dsa_2024.algorithms;

public class MinimumSubArray {

    public int minSubArrayLen(int target, int[] nums){
        int l =0, total = 0;
        int res = Integer.MAX_VALUE;

        for(int r = 0; r < nums.length; r++){
            total += nums[r];
            while (total >= target) {
                res = Math.min(res, r - l + 1);
                total -= nums[l++];
            }
        }
        return res == Integer.MAX_VALUE ? 0: res;
    }
}
