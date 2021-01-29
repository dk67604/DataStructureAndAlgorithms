package main.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalAccountBalancing {
    public static void main(String[] args) {
        OptimalAccountBalancing optimalAccountBalancing = new OptimalAccountBalancing();
        int[][] transactions = new int[][]{{0, 1, 10}, {2, 0, 5}};
        System.out.println(optimalAccountBalancing.minTransfers(transactions));
    }

    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t : transactions) {
            map.put(t[0], map.getOrDefault(t[0], 0) + t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) - t[2]);

        }
        List<Integer> list = new ArrayList<>();
        for (int v : map.values()) {
            if (v != 0)
                list.add(v);
        }
        return dfs(0, list);
    }

    private int dfs(int k, List<Integer> list) {
        if (k == list.size()) return 0;
        int curr = list.get(k);
        if (curr == 0) return dfs(k + 1, list);
        int min = Integer.MAX_VALUE;
        for (int i = k + 1; i < list.size(); i++) {
            int next = list.get(i);
            if (curr * next < 0) {
                list.set(i, curr + next);
                min = Math.min(min, 1 + dfs(k + 1, list));
                // backtrack
                list.set(i, next);
                // optimal solution
                if (curr + next == 0) break;
            }
        }
        return min;
    }
}
