package main.java.topcodingquestion.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class CountPalindromicSubsequences {
    public int countPalindromicSubsequencesWithDuplicate(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int g = 0; g < s.length(); g++) {
            for (int i = 0, j = g; j < s.length(); j++, i++) {
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 3 : 2;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i][j - 1] + dp[i + 1][j] + 1;
                    } else {
                        dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public int countPalindromicSubsequences(String s) {
        int[][] dp = new int[s.length()][s.length()];
        Map<Character, Integer> indexMap = new HashMap<>();
        int[] prev = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (!indexMap.containsKey(s.charAt(i))) {
                prev[i] = -1;
            } else {
                prev[i] = indexMap.get(s.charAt(i));
            }
            indexMap.put(s.charAt(i), i);
        }
        indexMap.clear();
        int[] next = new int[s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!indexMap.containsKey(s.charAt(i))) {
                next[i] = -1;
            } else {
                next[i] = indexMap.get(s.charAt(i));
            }
            indexMap.put(s.charAt(i), i);
        }
        for (int g = 0; g < s.length(); g++) {
            for (int i = 0, j = g; j < s.length(); j++, i++) {
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    dp[i][j] = 2;
                } else {
                    char sc = s.charAt(i);
                    char ec = s.charAt(j);

                    if (sc != ec) {
                        dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                    } else {
                        int nis = next[i];
                        int pie = prev[j];
                        if (nis > pie) {
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
                        } else if (pie == nis) {
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
                        } else {
                            dp[i][j] = 2 * dp[i + 1][j - 1] - dp[nis + 1][pie - 1];
                        }

                    }
                }
                dp[i][j] = dp[i][j] < 0 ? dp[i][j] + 1000000007 : dp[i][j] % 1000000007;

            }
        }
        return dp[0][s.length() - 1];
    }
}
