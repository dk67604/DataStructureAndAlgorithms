package main.java.topcodingquestion.treesandgraphs;

import java.util.*;

class CitiesCost {
    int src;
    int dest;
    int cost;

    public CitiesCost(int src, int dest, int cost) {
        this.src = src;
        this.dest = dest;
        this.cost = cost;
    }
}

public class ConnectingCitiesWithMinimumCost {
    public int minimumCost(int n, int[][] connections) {
        if (connections == null || connections.length == 0) return -1;
        int cost = 0;
        PriorityQueue<CitiesCost> minHeap = new PriorityQueue<>((c1, c2) -> c1.cost - c2.cost);
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<CitiesCost>> graph = new HashMap<>();
        for (int[] connection : connections) {
            graph.putIfAbsent(connection[0], new ArrayList<>());
            graph.get(connection[0]).add(new CitiesCost(connection[0], connection[1], connection[2]));
            graph.putIfAbsent(connection[1], new ArrayList<>());
            graph.get(connection[1]).add(new CitiesCost(connection[1], connection[0], connection[2]));
        }
        minHeap.offer(new CitiesCost(-1, 1, 0));
        while (!minHeap.isEmpty()) {
            int size = minHeap.size();
            for (int i = 0; i < size; i++) {
                CitiesCost citiesCost = minHeap.poll();
                if ((visited.contains(citiesCost.dest))) continue;
                visited.add(citiesCost.dest);
                cost += citiesCost.cost;
                for (CitiesCost nextCityCost : graph.get(citiesCost.dest)) {
                    minHeap.offer(nextCityCost);
                }
            }
        }
        if (visited.size() < n) return -1;
        return cost;

    }
}
