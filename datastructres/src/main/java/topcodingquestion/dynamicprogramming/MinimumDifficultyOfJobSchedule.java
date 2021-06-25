package main.java.topcodingquestion.dynamicprogramming;

public class MinimumDifficultyOfJobSchedule {
    public int minDifficulty(int[] jobDifficulty, int D) {
        int N = jobDifficulty.length;
        if (N < D) return -1;
        int[][] dp = new int[D][N];
        dp[0][0] = jobDifficulty[0];//on first day minimum job difficulty is the job difficulty available at i-th day
        //fill first day with maximum difficulty among jobs done on that day
        for (int j = 1; j < N; j++) {
            dp[0][j] = Math.max(jobDifficulty[j], dp[0][j - 1]);
        }
        //Start filling for next day and so on
        for (int d = 1; d < D; d++) {
            //Look into contiguous sub-array
            for (int len = d; len < N; len++) {
                int localMax = Integer.MAX_VALUE;
                for (int schedule = len; schedule >= d; schedule--) {
                    localMax = Math.max(localMax, jobDifficulty[schedule]);
                    dp[d][len] = Math.min(dp[d][len], dp[d - 1][schedule - 1] + localMax);
                }
            }
        }
        return dp[D - 1][N - 1];
    }
}
