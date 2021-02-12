package main.java.leetcode.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        return helper(coins, 0, amount);

    }

    private int helper(int[] coins, int currentCoin, int rem) {
        if (rem < 0) return 0;
        if(rem == 0) return 1;

        int min = Integer.MAX_VALUE;
        for(int coin = currentCoin;coin < coins.length;coin++){
           int nComb = helper(coins,coin,rem-coins[coin]);
           if(nComb !=Integer.MAX_VALUE && nComb + 1 < min){
               min =nComb + 1;
           }
        }


        return min;
    }

    public static void main(String[] args) {
        int[] coins = {5, 10, 25, 100, 200};
        int amount = 100;
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(coins, amount));
        coins = new int[]{1, 2, 5};
        System.out.println(coinChange.coinCombination(coins, 11));
    }

    private int coinCombination(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = amount + 1;
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
