package main.java.leetcode.dynamicprogramming;

public class RegularExpressionMatching {

    public static void main(String[] args) {
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
        System.out.println(regularExpressionMatching.isMatch("mississippi", "mis*is*p*"));
    }

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    if (p.charAt(i - 1) == '*') {
                        dp[i][j] = dp[i - 2][j];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    char pc = p.charAt(i - 1);
                    char sc = s.charAt(j - 1);

                    if (pc == '*') {
                        dp[i][j] = dp[i - 2][j];
                        char pslc = p.charAt(i - 2);
                        if (pslc == '.' || pslc == sc) {
                            dp[i][j] = dp[i][j] || dp[i][j - 1];
                        }
                    } else if (pc == '.' || pc == sc) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }

            }
        }
        return dp[p.length()][s.length()];
    }
}
