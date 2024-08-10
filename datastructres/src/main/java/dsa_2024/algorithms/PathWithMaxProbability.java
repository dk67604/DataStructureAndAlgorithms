package main.java.dsa_2024.algorithms;

import java.util.*;

class Pair{
    int node;
    double prob;

    public Pair(int node, double prob){
        this.node = node;
        this.prob = prob;
    }
}

public class PathWithMaxProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, Map<Integer, Double>> adjList = new HashMap<>();
        for(int i =0; i< edges.length; i++){
            int src = edges[i][0], dst = edges[i][1];
            adjList.putIfAbsent(src, new HashMap<>());
            adjList.get(src).put(dst, succProb[i]);
            adjList.putIfAbsent(dst, new HashMap<>());
            adjList.get(dst).put(src, succProb[i]);
        }

        Queue<Pair> queue = new PriorityQueue<Pair>((n1,n2) -> Double.compare(n2.prob ,n1.prob));
        queue.add(new Pair(start_node,1.0));
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            if (cur.node == end_node){
                return cur.prob;
            }
            if (visited.contains(cur.node)) {
                continue;
            }
            visited.add(cur.node);

            for(int neighbor: adjList.getOrDefault(cur.node, new HashMap<>()).keySet()){
                if(!visited.contains(neighbor)){
                    queue.add(new Pair(neighbor, adjList.get(cur.node).get(neighbor)* cur.prob));
                }
            }

        }
        return 0;
    }

}
