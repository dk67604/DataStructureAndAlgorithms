package main.java.leetcode.dynamicprogramming;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        //find the sum of all array elements
        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum % 2 != 0) return false;
        int subsetSum = totalSum / 2; // minimumSum we expect to exist in array to divide into 2 equal subset
        int n = nums.length;
        Boolean[][] memo = new Boolean[n + 1][subsetSum + 1];
        return dfs(nums, n, memo, subsetSum);
    }

    private boolean dfs(int[] nums, int n, Boolean[][] memo, int subsetSum) {
        // base case
        if (subsetSum == 0) return true;
        if (n == 0 || subsetSum < 0)
            return false; // fail to find a subset
        // check if subsetSum for a given n already exists in memo
        if (memo[n][subsetSum] == true)
            return memo[n][subsetSum];
        boolean result = dfs(nums, n - 1, memo, subsetSum - nums[n - 1]) ||
                dfs(nums, n - 1, memo, subsetSum); // first remove the next element then try without including
        // in subset
        memo[n][subsetSum] = result;
        return result;
    }
}
