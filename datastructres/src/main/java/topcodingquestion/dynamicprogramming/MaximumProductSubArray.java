package main.java.topcodingquestion.dynamicprogramming;

import java.util.*;
import java.util.stream.Collectors;

public class MaximumProductSubArray {
    public int maxProductSubArray(int[] nums){
        if(nums.length==1)
            return nums[0];
        int current_max_prod=nums[0];
        int ans=nums[0];
        int prev_min_product=nums[0];
        int prev_max_product=nums[0];
       for(int i =1; i< nums.length;i++){
           current_max_prod = Math.max(Math.max(prev_max_product* nums[i],prev_min_product*nums[i]),nums[i]);
           int current_min_prod = Math.min(Math.min(prev_max_product* nums[i],prev_min_product*nums[i]),nums[i]);
           prev_max_product = current_max_prod;
           prev_min_product = current_min_prod;
           ans = Math.max(ans,current_max_prod);
       }
       return ans;
    }
}
