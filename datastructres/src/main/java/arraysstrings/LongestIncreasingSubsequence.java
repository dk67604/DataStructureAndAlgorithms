package main.java.arraysstrings;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int[] T = new int[nums.length];
        int max =1;
        Arrays.fill(T,1);
        for(int i =1; i< nums.length;i++){
            for(int j =0; j<i;j++){
                if(nums[i] > nums[j]){ // check if the current element is greater then previous
                    if(T[j] + 1 > T[i]){ // If greater then, check if current index has higher LIS length
                        T[i] = T[j] +1; // Update the current index with new length
                        max = Math.max(max,T[i]); // Update global max length of LIS
                    }
                }
            }
        }

        return max;

    }
}
