package main.java.topcodingquestion.treesandgraphs;

import main.java.datastructure.GNode;
import main.java.datastructure.Graph;

import java.util.HashSet;
import java.util.Set;

public class CycleInUndirectedGraph {
    public static void main(String[] args) {
        Graph graph = Graph.getUndirectedGraph(true);
        CycleInUndirectedGraph cycleInUndirectedGraph = new CycleInUndirectedGraph();
        System.out.println("Has Cycle:" + cycleInUndirectedGraph.hasCycleDFS(graph));
        graph = Graph.getUndirectedGraph(false);
        System.out.println("Has Cycle:" + cycleInUndirectedGraph.hasCycleDFS(graph));
    }

    public boolean hasCycleDFS(Graph graph) {
        Set<GNode> visited = new HashSet<>();
        for (GNode vertex : graph.getNodes()) {
            if (visited.contains(vertex)) {
                continue;
            }
            boolean flag = hasCycleDFSUtil(graph, vertex, visited, new GNode("-1", -1));
            if (flag) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycleDFSUtil(Graph graph, GNode vertex, Set<GNode> visited, GNode parent) {
        visited.add(vertex);
        for (GNode adj : graph.getAdjacentNodes(vertex)) {
            if (adj.equals(parent)) {
                continue;
            }
            if (visited.contains(adj)) {
                return true;
            }
            boolean hasCycle = hasCycleDFSUtil(graph, adj, visited, vertex);
            if (hasCycle) {
                return true;
            }
        }
        return false;
    }
}
