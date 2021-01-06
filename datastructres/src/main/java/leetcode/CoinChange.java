package main.java.leetcode;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        return helper(coins,0,amount);

    }

    private int helper(int[] coins,int currentCoin,int rem){
        if(rem < 0) return 0;
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
        System.out.println(coinChange.coinChange(coins,amount));
    }
}
