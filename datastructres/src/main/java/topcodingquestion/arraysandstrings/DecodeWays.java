package main.java.topcodingquestion.arraysandstrings;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/decode-ways/solution/
public class DecodeWays {
    Map<Integer, Integer> memo = new HashMap<>();

    // Time: O(n),Space: O(n)
    public int numDecodingsRecursiveWithMemo(String s) {
        return helper(0, s);
    }

    private int helper(int index, String s) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        if (index == s.length() - 1) {
            return 1;
        }
        int ans = helper(index + 1, s);
        if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            ans += helper(index + 2, s);
        }
        memo.put(index, ans);
        return ans;
    }

    public int numDecodingsI(String s) {
        if (s.charAt(0) == '0') return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;//to handle empty string when we look two index back
        dp[1] = s.charAt(0) == '0' ? 0 : 1;// 1 size digit has 1 way to decode
        for (int i = 2; i < dp.length; i++) {
            // Check if successful single digit decode is possible.
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
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
