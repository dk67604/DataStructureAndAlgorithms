package main.java.topcodingquestion.treesandgraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/all-paths-from-source-lead-to-destination/solution/
public class AllPathFromTheSourceToDestination {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = buildGraph(n, edges);
        return leadsToDest(graph, source, destination, new Color[n]);
    }

    private boolean leadsToDest(Map<Integer, List<Integer>> graph, int node, int destination,
                                Color[] states) {
        // If the state is GRAY, this is a backward edge and hence, it creates a loop.
        if (states[node] != null) {
            return states[node] == Color.BLACK;
        }
        // If this is a leaf node, it should be equal to the destination.
        if (graph.get(node).size() == 0) {
            return node == destination;
        }

        // Now, we are processing this node. So we mark it as GRAY
        states[node] = Color.GRAY;
        for (int nei : graph.get(node)) {
            // If we get a `false` from any recursive call on the neighbors, we short circuit and return from there.
            if (!leadsToDest(graph, nei, destination, states)) return false;
        }
        // Recursive processing done for the node. We mark it BLACK
        states[node] = Color.BLACK;
        return true;

    }

    private Map<Integer, List<Integer>> buildGraph(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        //Initialize graph,remember this graph is directed graph
        for (int i = 0; i < n; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
        }
        //Build graph
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        return graph;
    }

    // We don't use the state WHITE as such anywhere. Instead, the "null" value in the states array below is a substitute for WHITE.
    enum Color {GRAY, BLACK}

}
