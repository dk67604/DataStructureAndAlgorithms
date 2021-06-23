package main.java.topcodingquestion.dynamicprogramming;

public class PalindromicSubString {
    public int countSubstrings(String s) {
        if (s.length() == 0 || s.length() == 1) return 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        //Use gap strategy
        // row index denotes starting position and column index denotes ending position
        for (int g = 0; g < s.length(); g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true;
                }
                if (dp[i][j] == true) {
                    count += 1;
                }
            }
        }
        return count;
    }
}
