package main.java.topcodingquestion.dynamicprogramming;

public class CoinChangePermutation {
    public int coinChangePermutation(int[] coins, int amount){
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int amt = 1 ; amt< dp.length;amt++){
            for (int coin: coins){
                if (coin <= amt) {
                    int remainingAmount = amt - coin;
                    dp[amt] += dp[remainingAmount];
                }
            }
        }
        return dp[amount];
    }
}
