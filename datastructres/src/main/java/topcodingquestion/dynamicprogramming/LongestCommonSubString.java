package main.java.topcodingquestion.dynamicprogramming;

//https://www.youtube.com/watch?v=NvmJBCn4eQI
public class LongestCommonSubString {
    public static void main(String[] args) {
        LongestCommonSubString longestCommonSubString = new LongestCommonSubString();
        String s1 = "pqabcxy";
        String s2 = "xyzabcp";
        System.out.println(longestCommonSubString.findLength(s1, s2));
    }

    public int findLength(String s1, String s2) {
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                if (c1 != c2) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
