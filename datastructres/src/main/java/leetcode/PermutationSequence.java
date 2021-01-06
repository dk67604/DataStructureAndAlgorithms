package main.java.leetcode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] fact = new int[n+1];
        fact[0] = 1;
        for(int i =1; i<=n; i++){
            fact[i] = fact[i-1] *i;
        }
        List<Integer> nums = IntStream.range(1,n+1).mapToObj(x ->x).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder("");
        k--;
        for(int i = 1; i<=n; i++){
            int index = k/ fact[n-i];
            sb.append(nums.get(index));
            nums.remove(index);
            k -= index* fact[n-i];
        }
        return sb.toString();
    }
}
