package main.java.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class KSimilarStrings {
    //Use BFS to find th shortest distance
    public int kSimilarity(String A, String B) {
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        queue.offer(A);
        seen.add(A);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(B))
                    return res;
                int j = 0;
                while (j < curr.length() && curr.charAt(j) == B.charAt(j)) {
                    j++;
                }
                for (int k = j + 1; k < curr.length(); k++) {
                    if (curr.charAt(k) == B.charAt(j) && curr.charAt(k) != B.charAt(k)) {
                        String next = swap(curr, j, k);
                        if (!seen.contains(next)) {
                            seen.add(next);
                            queue.offer(next);
                        }
                    }
                }
            }
            res++;
        }
        return res;
    }

    private String swap(String curr, int i, int j) {
        char[] chars = curr.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
