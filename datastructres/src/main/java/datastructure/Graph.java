package main.java.datastructure;

import java.util.*;

public class Graph {
    private final Map<GNode, LinkedList<GNode>> adjacencyMap;
    boolean directed;

    public Graph(boolean directed) {
        this.directed = directed;
        this.adjacencyMap = new HashMap<>();
    }

    public static Graph getSampleGraph() {
        Graph graph = new Graph(true);
        graph.addEdge(new GNode("0", 0), new GNode("1", 1));
        graph.addEdge(new GNode("0", 0), new GNode("3", 3));
        graph.addEdge(new GNode("1", 1), new GNode("4", 4));
        graph.addEdge(new GNode("2", 2), new GNode("5", 5));
        graph.addEdge(new GNode("4", 4), new GNode("5", 5));
        return graph;
    }

    public static Graph getSampleGraphII() {
        Graph graph = new Graph(true);
        graph.addEdge(new GNode("1", 1), new GNode("2", 2));
        graph.addEdge(new GNode("1", 1), new GNode("3", 3));
        graph.addEdge(new GNode("2", 2), new GNode("3", 3));
        graph.addEdge(new GNode("4", 4), new GNode("1", 1));
        graph.addEdge(new GNode("4", 4), new GNode("5", 5));
        graph.addEdge(new GNode("5", 5), new GNode("6", 6));
        graph.addEdge(new GNode("6", 6), new GNode("4", 4));
        return graph;
    }

    public static Graph getUndirectedGraph(boolean hasCycle) {
        Graph graph = new Graph(false);
        graph.addEdge(new GNode("0", 0), new GNode("1", 1));
        graph.addEdge(new GNode("1", 1), new GNode("2", 2));
        graph.addEdge(new GNode("0", 0), new GNode("3", 3));
        graph.addEdge(new GNode("3", 3), new GNode("4", 4));
        graph.addEdge(new GNode("4", 4), new GNode("5", 5));
        if (hasCycle)
            graph.addEdge(new GNode("5", 5), new GNode("1", 1));
        return graph;
    }

    public static void main(String[] args) {
        Graph graph = getSampleGraph();
        System.out.println(graph.toString());
    }

    //This method add a vertex to the graph
    public void addVertex(GNode node) {
        this.adjacencyMap.put(node, new LinkedList<GNode>());
    }

    //This function add edge between source and destination
    public void addEdge(GNode source, GNode destination) {
        if (!adjacencyMap.containsKey(source)) {
            addVertex(source);
        }
        if (!adjacencyMap.containsKey(destination)) {
            addVertex(destination);
        }
        adjacencyMap.get(source).add(destination);
        if (!directed) {
            adjacencyMap.get(destination).add(source);
        }
    }

    //This functions gives the size of vertices present in the graph
    public int getVertexCount() {
        return adjacencyMap.keySet().size();
    }

    // This function gives the count of edges
    public int getEdgesCount() {
        int count = 0;
        for (GNode v : adjacencyMap.keySet()) {
            count += adjacencyMap.get(v).size();
        }
        if (!directed) {
            count /= 2;
        }
        return count;
    }

    // This function check whether graph has vertex
    public boolean hasVertex(GNode v) {
        return adjacencyMap.containsKey(v);
    }

    // This function checks whether source and destination has an edge
    public boolean hasEdge(GNode source, GNode destination) {
        return adjacencyMap.containsKey(source) && adjacencyMap.get(source) != null
                && adjacencyMap.get(source).contains(destination);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (GNode p : adjacencyMap.keySet()) {
            stringBuilder.append(p.toString() + ":");
            for (GNode v : adjacencyMap.get(p)) {
                stringBuilder.append(v.toString() + " ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public Set<GNode> getNodes() {
        return adjacencyMap.keySet();
    }

    public List<GNode> getAdjacentNodes(GNode node) {
        return adjacencyMap.containsKey(node) ? adjacencyMap.get(node) : new LinkedList<>();
    }

}
