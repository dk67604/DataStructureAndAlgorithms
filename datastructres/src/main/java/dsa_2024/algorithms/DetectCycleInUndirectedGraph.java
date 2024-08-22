package main.java.dsa_2024.algorithms;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInUndirectedGraph {
    public boolean hasCycle(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, graph)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, graph)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true; // A cycle is detected
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycleInUndirectedGraph cycleDetection = new DetectCycleInUndirectedGraph();
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {4, 2}};
        System.out.println(cycleDetection.hasCycle(4, edges)); // Output: true
    }
}
