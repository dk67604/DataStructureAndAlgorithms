package main.java.topcodingquestion.arraysandstrings;
//https://www.youtube.com/watch?v=We3YDTzNXEk
//https://leetcode.com/problems/edit-distance/
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int r = word1.length() + 1;
        int c = word2.length() + 1;
        int[][] dp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    //Character are same get the left-diagonal value
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //Character are different minimum all of 3 position -> left,up,left-diagonal
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[r - 1][c - 1];
    }
}
