package main.java.topcodingquestion.arraysandstrings.besttimetobuyandsellstocks;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 * <p>
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 * <p>
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * <p>
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * Example 4:
 * <p>
 * Input: prices = [1]
 * Output: 0
 */
public class Question3 {
    public int maxProfit(int[] prices) {
        int mpist = 0; //max price if sell today
        int leastsf = prices[0]; //least price so far
        int mpibt = 0; //max price if bought today
        int maxaft = prices[prices.length - 1]; //max price after today
        int[] dpr = new int[prices.length + 1]; // max profit if bought today or after today
        int[] dpl = new int[prices.length];//ith represents maximum price sell up to today
        for (int l = 1; l < prices.length; l++) {
            dpl[l] = Math.max(dpl[l - 1], prices[l] - leastsf);
            leastsf = Math.min(leastsf, prices[l]);

            int r = prices.length - 1 - l;
            dpr[r] = Math.max(dpr[r + 1], maxaft - prices[r]);
            maxaft = Math.max(maxaft, prices[r]);

        }

        int op = 0;//overall profit is when sum of dpl and dpr is maximum
        for (int i = 0; i < dpl.length; ++i) {
            op = Math.max(dpl[i] + dpr[i], op);
        }
        return op;
    }
}
