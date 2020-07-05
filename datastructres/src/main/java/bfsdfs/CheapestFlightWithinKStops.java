package main.java.bfsdfs;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CheapestFlightWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer,Integer>> adjList = new HashMap<>();
        for(int[] f:flights){
            if(!adjList.containsKey(f[0])) adjList.put(f[0],new HashMap<>());
            adjList.get(f[0]).put(f[1],f[2]);
        }
        //Min Heap to store min price at the root
        // 1st element: price
        // 2nd element: src
        // 3rd element: stops to reach destination
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        minHeap.offer(new int[]{0,src,k+1});
        while (!minHeap.isEmpty()){
            int[] top = minHeap.poll();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if(city == dst) return price;
            if(stops>0){
                Map<Integer,Integer> adj = adjList.getOrDefault(city,new HashMap<>());
                for(int a:adj.keySet()){
                    minHeap.offer(new int[]{price+adj.get(a),a,stops-1});
                }
            }
        }
        return -1;
    }
}
