package main.java.topcodingquestion.dynamicprogramming;

/**
 * https://leetcode.com/problems/number-of-music-playlists/
 * Your music player contains n different songs. You want to listen to goal songs (not necessarily different) during your trip. To avoid boredom, you will create a playlist so that:
 *
 * Every song is played at least once.
 * A song can only be played again only if k other songs have been played.
 * Given n, goal, and k, return the number of possible playlists that you can create. Since the answer can be very large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3, goal = 3, k = 1
 * Output: 6
 * Explanation: There are 6 possible playlists: [1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], and [3, 2, 1].
 * Example 2:
 *
 * Input: n = 2, goal = 3, k = 0
 * Output: 6
 * Explanation: There are 6 possible playlists: [1, 1, 2], [1, 2, 1], [2, 1, 1], [2, 2, 1], [2, 1, 2], and [1, 2, 2].
 * Example 3:
 *
 * Input: n = 2, goal = 3, k = 1
 * Output: 2
 * Explanation: There are 2 possible playlists: [1, 2, 1] and [2, 1, 2].
 */
public class NoOfMusictPlaylists {
    public int numMusicPlaylists(int N, int L, int K) {
        int mod = 1_000_000_007;
        long[][] dp = new long[L+1][N+1];
        dp[0][0] = 1;
        for(int i = 1; i<=L;i++){
            for(int j =1;j<=N;j++){
                dp[i][j] += dp[i-1][j-1] * (N-j+1); // Played song first time
                dp[i][j] += dp[i-1][j] * Math.max(j-K,0); //Played old song
                dp[i][j] %=mod;
            }
        }
        return (int) dp[L][N];
    }
}
