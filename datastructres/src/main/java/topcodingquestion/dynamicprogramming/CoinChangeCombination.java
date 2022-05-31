package main.java.topcodingquestion.dynamicprogramming;

public class CoinChangeCombination {

    public int coinChangeCombination(int[] coins, int target){
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 0 ; i< coins.length;i++){
            for (int j = coins[i] ; j < dp.length;j++){
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        CoinChangeCombination coinChangeCombination = new CoinChangeCombination();
        System.out.println(coinChangeCombination.coinChangeCombination(new int[]{2,3,5},7));
    }
}
