package main.java.leetcode;

import java.awt.*;

public class PaintHouse {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;

        int n = costs.length, k = costs[0].length;
        // min1 is the index of the 1st-smallest cost till previous house
        // min2 is the index of the 2nd-smallest cost till previous house
        int min1 = -1, min2 = -1;

        for (int i = 0; i < n; i++) {
            int last1 = min1, last2 = min2;
            min1 = -1; min2 = -1;

            for (int j = 0; j < k; j++) {
                if (j != last1) {
                    // current color j is different to last min1
                    costs[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];
                } else {
                    costs[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
                }

                // find the indices of 1st and 2nd smallest cost of painting current house i
                if (min1 < 0 || costs[i][j] < costs[i][min1]) {
                    min2 = min1; min1 = j;
                } else if (min2 < 0 || costs[i][j] < costs[i][min2]) {
                    min2 = j;
                }
            }
        }

        return costs[n - 1][min1];
    }


    public int minCostIII(int[][] costs) {
        if(costs.length == 0) return 0;
        if(costs[0].length == 1) return costs[0][0];
        int n = costs.length;
        int k = costs[0].length;
        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;
        int[][] dp = new int[n][k];
        // Initialize first row
        for(int j = 0;j < dp[0].length; j++){
            dp[0][j] = costs[0][j];
            if(costs[0][j] <= least){
                sleast = least;
                least = costs[0][j];
            }
            else if (costs[0][j] <= sleast ){
                sleast=costs[0][j];
            }
        }
        for(int i = 1; i < n;i++){
            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;
            for(int j = 0; j < k;j++){

                if(least == dp[i-1][j]){
                    dp[i][j] = sleast + costs[i][j];
                }else{
                    dp[i][j] = least + costs[i][j];
                }
                if(dp[i][j] <= nleast){
                    nsleast = nleast;
                    nleast = dp[i][j];
                }
                else if (dp[i][j] <= nsleast ){
                    nsleast=Math.min(dp[i][j],nsleast);
                }
            }
            least = nleast;
            sleast = nsleast;
        }

        return least;

    }

    public int minCostIV(int[][] costs) {
        if(costs.length == 0) return 0;
        if(costs[0].length == 1) return costs[0][0];
        int n = costs.length;
        int k = costs[0].length;
        int least = 0;
        int sleast = 0;
        int[] dp = new int[k];
        for(int i = 0; i < n;i++){
            int nleast = least;
            int nsleast = sleast;
            least = Integer.MAX_VALUE;
            sleast = Integer.MAX_VALUE;

            for(int j = 0; j < k;j++){
                dp[j] = (dp[j] == nleast ? nsleast : nleast) + costs[i][j];
                if(least <= dp[j]){
                    sleast=Math.min(dp[j],sleast);
                }
                else {
                    sleast = least;
                    least = dp[j];
                }
            }

        }

        return least;

    }

    public static void main(String[] args) {
        int[][] costs = {{3,20,7,7,16,8,7,12,11,19,1},
                {10,14,3,3,9,13,4,12,14,13,1},
                {10,1,14,11,1,16,2,7,16,7,19},
                {13,20,17,15,3,13,8,10,7,8,9},
                {4,14,18,15,11,9,19,3,15,12,15},
                {14,12,16,19,2,12,13,3,11,10,9},{18,12,10,16,19,9,18,4,14,2,4}};
        PaintHouse paintHouse = new PaintHouse();
        System.out.println(paintHouse.minCostIV(costs));


    }
}
