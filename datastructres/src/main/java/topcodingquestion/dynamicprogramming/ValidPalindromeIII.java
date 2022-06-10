package main.java.topcodingquestion.dynamicprogramming;

public class ValidPalindromeIII {
    public boolean isValidPalindrome(String s, int k) {
        if (s.length() == 0 || s.length() == 1) return true;;
        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 2; i >=0; i--) {
            for (int j = i+1; j < s.length(); j++) {

                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                // Case 2: Character at `i` does not equal character at `j`.
                // Either delete character at `i` or delete character at `j`
                // and try to match the two pointers using recursion.
                // We need to take the minimum of the two results and add 1
                // representing the cost of deletion.
                else{
                    dp[i][j] = 1 + Math.min(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1] <=k;
    }
}
