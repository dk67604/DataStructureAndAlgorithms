package main.java.leetcode;

import java.util.Arrays;

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        int N = costs.length/2;
        int [] refunds = new int[N*2];
        int index =0;
        int minCosts = 0;
        for (int[] cost:costs){
            refunds[index++] = cost[1] - cost[0];
            minCosts+= cost[0];
        }

        Arrays.sort(refunds);
        for (int i =0;i<N;i++){
            minCosts+=refunds[i];
        }
        return minCosts;
    }
}
