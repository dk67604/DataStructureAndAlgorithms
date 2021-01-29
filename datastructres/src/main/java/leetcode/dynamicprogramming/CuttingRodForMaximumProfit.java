package main.java.leetcode.dynamicprogramming;

public class CuttingRodForMaximumProfit {
    public int maximumProfit(int[] prices) {
        int[] np = new int[prices.length + 1]; // convert 0 index prices to 1-index
        for (int i = 0; i < prices.length; i++) {
            np[i + 1] = prices[i];
        }
        int[] dp = new int[np.length];
        dp[0] = 0;
        dp[1] = np[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = np[i];
            int li = 1;
            int ri = i - 1;
            while (li <= ri) {
                if (dp[li] + dp[ri] > dp[i]) {
                    dp[i] = dp[li] + dp[ri];
                }
            }
        }
        return dp[dp.length - 1];
    }
}
