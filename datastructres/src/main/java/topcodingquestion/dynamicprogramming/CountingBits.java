package main.java.topcodingquestion.dynamicprogramming;

import java.util.Arrays;

public class CountingBits {
    public int[] countBits(int n){
        int[] dp = new int[n+1];
        int offset = 1;
        for (int i =1; i<=n; i++){
            if (offset * 2 == i){
                offset = i;
            }
            dp[i] = 1 + dp[i - offset];
        }
        return dp;
    }

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        System.out.println(Arrays.toString(countingBits.countBits(2)));
    }
}
