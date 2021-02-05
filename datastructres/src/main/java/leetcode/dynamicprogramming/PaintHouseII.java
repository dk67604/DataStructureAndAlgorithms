package main.java.leetcode.dynamicprogramming;

public class PaintHouseII {
    public static void main(String[] args) {
        int[][] costs = {{1, 5, 3}, {2, 9, 4}};
        PaintHouseII paintHouseII = new PaintHouseII();
        System.out.println(paintHouseII.minCostII(costs));
    }

    public int minCostII(int[][] costs) {
        if (costs.length == 0) return 0;
        if (costs[0].length == 1) return costs[0][0];
        int n = costs.length;
        int k = costs[0].length;
        int least = 0;
        int sleast = 0;
        int[] dp = new int[k];
        for (int i = 0; i < n; i++) {
            int nleast = least;
            int nsleast = sleast;
            least = Integer.MAX_VALUE;
            sleast = Integer.MAX_VALUE;

            for (int j = 0; j < k; j++) {
                dp[j] = (dp[j] == nleast ? nsleast : nleast) + costs[i][j];
                if (least <= dp[j]) {
                    sleast = Math.min(dp[j], sleast);
                } else {
                    sleast = least;
                    least = dp[j];
                }
            }

        }

        return least;
    }
}
