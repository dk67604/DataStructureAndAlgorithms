package main.java.leetcode.dynamicprogramming;

public class Knapsack {

    //1. Recursion Time Complexity : O(2^n) Space Complexity: O(n)
    public int solveKnapsack(int[] profits, int[] weights, int capacity, String type) {
        if (type == "recursive") {
            return this.knapsackRecursive(profits, weights, capacity, 0);
        }
        return -1;
    }

    private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
        //base case
        if (capacity <= 0 || currentIndex >= profits.length) {
            return 0;
        }
        // recursive call after choosing the element at the currentIndex
        // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
        int profit1 = 0;
        if (weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] + knapsackRecursive(profits, weights, capacity, currentIndex + 1);
        }
        // recursive call after excluding the element at the currentIndex
        int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);
        return Math.max(profit1, profit2);

    }

    private int knapsackTopDown(Integer[][] dp, int[] profits, int[] weights, int capacity, int currentIndex) {
        //base case
        if (capacity <= 0 || currentIndex >= profits.length) {
            return 0;
        }
        // if we have already solved a similar problem, return the result from memory
        if (dp[currentIndex][capacity] != null) {
            return dp[currentIndex][capacity];
        }
        // recursive call after choosing the element at the currentIndex
        // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
        int profit1 = 0;
        if (weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] + knapsackRecursive(profits, weights, capacity, currentIndex + 1);
        }
        // recursive call after excluding the element at the currentIndex
        int profit2 = knapsackTopDown(dp, profits, weights, capacity, currentIndex + 1);
        dp[currentIndex][capacity] = Math.max(profit1, profit2);
        return dp[currentIndex][capacity];
    }

    private int solveKnapsackBottomUp(int[] profits, int[] weights, int capacity) {
        // base case
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length) {
            return 0;
        }
        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];
        // populate the capacity=0 columns, with '0' capacity we have '0' profit
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        // if we have only one weight, we will take it if it is not more than the capacity
        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c) {
                dp[0][c] = profits[0];
            }
        }
        // process all sub-arrays for all the capacities
        for (int i = 1; i < n; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0, profit2 = 0;
                // include the item, if it is not more than the capacity
                if (weights[i] <= c)
                    profit1 = profits[i] + dp[i - 1][c - weights[i]];
                //exclude the item
                profit2 = dp[i - 1][c];
                //take maximum
                dp[i][c] = Math.max(profit1, profit2);
            }
        }
        // maximum profit will be at the bottom-right corner
        return dp[n - 1][capacity];
    }

}
