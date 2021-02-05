package main.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class PairSongDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int t : time) {
            int secondPair = (60 - t % 60) % 60;
            ans += map.getOrDefault(secondPair, 0);// in current HashMap, get the number of songs that if adding t equals to a multiple of 60.
            map.put(t % 60, 1 + map.getOrDefault(t % 60, 0));// update the number of t % 60.
        }
        return ans;
    }
}
