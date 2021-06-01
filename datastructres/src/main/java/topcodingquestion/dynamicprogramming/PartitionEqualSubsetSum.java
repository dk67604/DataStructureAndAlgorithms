package main.java.topcodingquestion.dynamicprogramming;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = dp.length - 1; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[dp.length - 1];
    }
}
