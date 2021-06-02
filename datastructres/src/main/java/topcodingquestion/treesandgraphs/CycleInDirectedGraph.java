package main.java.topcodingquestion.treesandgraphs;

import main.java.datastructure.GNode;
import main.java.datastructure.Graph;

import java.util.HashSet;
import java.util.Set;

public class CycleInDirectedGraph {
    public static void main(String[] args) {
        Graph graph1 = Graph.getSampleGraph();
        CycleInDirectedGraph cycleInDirectedGraph = new CycleInDirectedGraph();
        System.out.println("Has Cycle:" + cycleInDirectedGraph.hasCycle(graph1));
        Graph graph2 = Graph.getSampleGraphII();
        System.out.println("Has Cycle:" + cycleInDirectedGraph.hasCycle(graph2));

    }

    public boolean hasCycle(Graph graph) {
        Set<GNode> whiteSet = new HashSet<>();
        Set<GNode> graySet = new HashSet<>();
        Set<GNode> blackSet = new HashSet<>();
        for (GNode vertex : graph.getNodes()) {
            whiteSet.add(vertex);
        }
        while (whiteSet.size() > 0) {
            GNode current = whiteSet.iterator().next();
            if (dfs(graph, current, whiteSet, graySet, blackSet)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(Graph graph, GNode current, Set<GNode> whiteSet,
                        Set<GNode> graySet, Set<GNode> blackSet) {
        //move current to gray set from white set and then explore it.
        moveVertex(current, whiteSet, graySet);
        for (GNode neighbor : graph.getAdjacentNodes(current)) {
            //if in black set means already explored so continue.
            if (blackSet.contains(neighbor)) {
                continue;
            }
            //if in gray set then cycle found.
            if (graySet.contains(neighbor)) {
                return true;
            }
            if (dfs(graph, neighbor, whiteSet, graySet, blackSet)) {
                return true;
            }
        }
        //move vertex from gray set to black set when done exploring.
        moveVertex(current, graySet, blackSet);
        return false;
    }

    private void moveVertex(GNode vertex, Set<GNode> sourceSet,
                            Set<GNode> destinationSet) {
        sourceSet.remove(vertex);
        destinationSet.add(vertex);
    }

}
