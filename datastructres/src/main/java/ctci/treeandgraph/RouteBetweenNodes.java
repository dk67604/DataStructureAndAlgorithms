package main.java.ctci.treeandgraph;

import main.java.datastructure.GNode;
import main.java.datastructure.Graph;
import main.java.datastructure.State;

import java.util.LinkedList;
import java.util.Queue;

public class RouteBetweenNodes {

    public static void main(String[] args) {
        RouteBetweenNodes routeBetweenNodes = new RouteBetweenNodes();
        GNode start = new GNode("0", 0);
        GNode end = new GNode("5", 5);
        System.out.println("Is route exist between " + start.toString() + " and "
                + end.toString() + ":" + routeBetweenNodes.isRouteExistBetweenNodes(Graph.getSampleGraph(), start, end));
    }

    public boolean isRouteExistBetweenNodes(Graph graph, GNode start, GNode end) {
        if (start == end) {
            return true;
        }

        Queue<GNode> queue = new LinkedList<>();
        //Set the node state
        for (GNode u : graph.getNodes()) {
            u.state = State.Unvisited;
        }
        start.state = State.Visiting;
        queue.add(start);
        GNode u;
        while (!queue.isEmpty()) {
            u = queue.poll();
            if (u != null) {
                for (GNode v : graph.getAdjacentNodes(u)) {
                    if (v.state == State.Unvisited) {
                        if (v.equals(end)) {
                            return true;
                        } else {
                            v.state = State.Visiting;
                            queue.add(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
        }
        return false;

    }
}
