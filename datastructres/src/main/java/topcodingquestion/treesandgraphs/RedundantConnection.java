package main.java.topcodingquestion.treesandgraphs;

import java.util.*;

//https://leetcode.com/problems/redundant-connection/
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        //Initialize Graph
        for (int[] edge : edges) {
            graph.put(edge[0], new ArrayList<>());
            graph.put(edge[1], new ArrayList<>());
        }

        for (int[] edge : edges) {
            Set<Integer> seen = new HashSet<>();//clear for each dfs
            if (!graph.get(edge[0]).isEmpty() && !graph.get(edge[1]).isEmpty()
                    && dfs(graph, edge[0], edge[1], seen)) {
                return edge;
            }
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        throw new AssertionError();

    }

    //For each edge (u, v), traverse the graph with a depth-first search to see if we can connect u to v. If we can, then it must be the duplicate edge.
    private boolean dfs(Map<Integer, List<Integer>> graph, int source, int target, Set<Integer> seen) {
        if (!seen.contains(source)) {
            seen.add(source);
            if (source == target) return true;
            for (int nei : graph.get(source)) {
                if (dfs(graph, nei, target, seen)) return true;
            }
        }
        return false;
    }
}
