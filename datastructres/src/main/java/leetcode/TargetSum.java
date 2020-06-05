package main.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        Map<Map.Entry<Integer,Integer>,Integer> map = new HashMap<>();
        int curr_sum=0;
        int index = nums.length -1;
        return helper(nums,S,map,index,curr_sum);
    }

    private int helper(int[] nums,int target,Map<Map.Entry<Integer,Integer>,Integer> map,int index,int curr_sum){
        Map.Entry<Integer,Integer> entry = Map.entry(index,curr_sum);
        if(map.containsKey(entry) )
            return map.get(entry);
        if (index<0 && curr_sum==target)
            return  1;
        if (index < 0)
            return 0;
        int positive = helper(nums,target,map,index-1,curr_sum+nums[index]);
        int negative = helper(nums,target,map,index-1,curr_sum + -nums[index]);
        entry = Map.entry(index,curr_sum);
        map.put(entry,positive+negative);
        return positive+negative;


    }
    public int findTargetSumWays3(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int S =3 ;
        TargetSum targetSum = new TargetSum();
        System.out.println(targetSum.findTargetSumWays3(nums,S));
    }
}
