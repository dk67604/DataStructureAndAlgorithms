package main.java.topcodingquestion.arraysandstrings.besttimetobuyandsellstocks;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//Best Time to Buy and Sell Stocks - One Transaction Allowed
public class Question1 {
    public int maxProfit(int[] prices) {
        int overallProfit = 0;
        int leastPriceSoFar = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < leastPriceSoFar) {
                leastPriceSoFar = prices[i];
            } else {
                overallProfit = Math.max(overallProfit, prices[i] - leastPriceSoFar);
            }
        }
        return overallProfit;
    }

}
