package main.java.topcodingquestion.dynamicprogramming;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum < S || -sum > -S || (sum + S) % 2 == 1) return 0;
        int[] dp = new int[(sum + S) / 2 + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = dp.length - 1; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        // Return the answer
        return dp[dp.length - 1];
    }


}
