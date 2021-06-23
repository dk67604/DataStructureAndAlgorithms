package main.java.topcodingquestion.arraysandstrings;
//https://leetcode.com/problems/decode-ways/
public class DecodeWays {
    public int numDecodingsI(String s) {
        if (s.charAt(0) == '0') return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) != '0') {
                dp[i + 1] += dp[i];
            }
            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[len];

    }

    //Optimized Space
    public int numDecodingsII(String s) {
        if (s.charAt(0) == '0') return 0;
        int len = s.length();

        int twoBack = 1;
        int oneBack = 1;
        for (int i = 1; i < len; i++) {
            int current = 0;
            if (s.charAt(i) != '0') {
                current += oneBack;
            }
            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                current += twoBack;
            }
            twoBack = oneBack;
            oneBack = current;
        }
        return oneBack;//when for loop is done, look one step behind for the answer

    }
}
