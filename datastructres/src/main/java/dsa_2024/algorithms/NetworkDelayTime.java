package main.java.dsa_2024.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k){
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
        for(int[] time: times){
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        //distance, node into pq
        Queue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[0] -n2[0]);
        pq.add(new int[]{0, k});
        boolean[] visited = new boolean[n+1];
        int res = 0;

        while (!pq.isEmpty()) {
            int [] cur = pq.poll();
            int curNode = cur[1];
            int currDist = cur[0];
            if(visited[curNode]) continue;
            visited[curNode] = true;
            res = currDist;
            n--;
            if(n == 0) return res;
            if(map.containsKey(curNode)){
                for(int next: map.get(curNode).keySet()){
                    pq.add(new int[]{currDist + map.get(curNode).get(next), next});
                }
            }
        }
        return n == 0? res: -1;
    }
}
