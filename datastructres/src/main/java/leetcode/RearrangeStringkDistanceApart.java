package main.java.leetcode;

import java.util.*;

public class RearrangeStringkDistanceApart {
    public String rearrangeString(String s, int k) {
        if(k==0) return s;
        int[] freq = new int[26];
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) freq[c - 'a']++;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int i = 0; i < 26; i++) if(freq[i] > 0) pq.add(new int[]{i, freq[i]});
        List<int[]> temp = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            ans.append((char)(current[0] + 'a'));

            current[1]--;
            //q.add(current);
            temp.add(current);

            if (temp.size() >= k) {
                int[] front = temp.remove(0);
                if (front[1] > 0) pq.add(front);
            }
        }
        return ans.length() == s.length() ? ans.toString() : "";
    }
}
