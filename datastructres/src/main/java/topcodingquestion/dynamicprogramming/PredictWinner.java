package main.java.topcodingquestion.dynamicprogramming;

//https://leetcode.com/problems/predict-the-winner/
public class PredictWinner {
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                if (g == 0) {
                    dp[i][j] = nums[i];
                } else if (g == 1) {
                    dp[i][j] = Math.max(nums[i], nums[j]);
                } else {
                    int val1 = nums[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
                    int val2 = nums[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]);
                    dp[i][j] = Math.max(val1, val2);
                }
            }
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int playerA = dp[0][dp.length - 1];
        int playerB = sum - playerA;
        return playerA - playerB >= 0;
    }
}
