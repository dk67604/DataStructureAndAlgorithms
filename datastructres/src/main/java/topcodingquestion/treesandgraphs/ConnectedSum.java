package main.java.topcodingquestion.treesandgraphs;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectedSum {
    public static void main(String[] args) {
        int n = 4;
        List<String> edges = new ArrayList<>();
        edges.add("1 2");
        edges.add("2 3");
        edges.add("3 4");
        edges.add("4 1");
        ConnectedSum connectedSum = new ConnectedSum();
        System.out.println(connectedSum.connectedSum(n, edges));
    }

    public int connectedSum(int n, List<String> edges) {
        if (n <= 1)
            return n;
        //Create adjacency list
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        Set<Integer> zeroEdges = new HashSet<>();
        for (String edge : edges) {
            String[] e = edge.split(" ");
            map.get(Integer.parseInt(e[0])).add(Integer.parseInt(e[1]));
            map.get(Integer.parseInt(e[1])).add(Integer.parseInt(e[0]));
        }
        //perform dfs from each node if it is not visited
        Set<Integer> visited = new HashSet<>();
        int result = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 0) {
                result += 1;
                zeroEdges.add(entry.getKey());
            }
        }

        for (int i = 1; i <= n; i++) {
            if (visited.add(i) && !zeroEdges.contains(i)) {
                AtomicInteger nodeCount = new AtomicInteger(1);
                dfsVisit(i, map, visited, nodeCount);
                result += Math.ceil(Math.sqrt(nodeCount.get()));

            }
        }

        return result;
    }

    private void dfsVisit(int i, Map<Integer, List<Integer>> map, Set<Integer> visited, AtomicInteger nodeCount) {
        for (int j : map.get(i)) {
            if (visited.add(j)) {
                nodeCount.getAndIncrement();
                dfsVisit(j, map, visited, nodeCount);
            }
        }
    }
}
