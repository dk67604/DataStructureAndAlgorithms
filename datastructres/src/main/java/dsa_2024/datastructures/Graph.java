package main.java.dsa_2024.datastructures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {
    private final Map<GNode<String>, LinkedList<GNode<String>>> adjacencyMap;
    boolean directed;

    public Graph(boolean directed) {
        this.directed = directed;
        this.adjacencyMap = new HashMap<>();
    }

    public Map<GNode<String>, LinkedList<GNode<String>>> getAdjacencyMap() {
        return this.adjacencyMap;
    }

    public void addEdge(GNode<String> source, GNode<String> destination) {
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

    // This functions gives the size of vertices present in the graph
    public int getVertexCount() {
        return adjacencyMap.keySet().size();
    }

    public int getEdgesCount(){
        int count = 0;
        for (GNode<String> v: adjacencyMap.keySet()){
            count += adjacencyMap.get(v).size();
        }
        if (!directed){
            count /= 2;
        }
        return count;
    }
    // This function checks whether source and destination has an edge
    public boolean hasEdge(GNode<String> source, GNode<String> destination){
        return adjacencyMap.containsKey(source) && adjacencyMap.get(source) != null
            && adjacencyMap.get(source).contains(destination);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (GNode<String> p: adjacencyMap.keySet()){
            stringBuilder.append(p.toString() + ":");
            for (GNode<String> v: adjacencyMap.get(p)){
                stringBuilder.append(v.toString() + " ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public Set<GNode<String>> getNodes() {
        return adjacencyMap.keySet();
    }

    public List<GNode<String>> getAdjacentNodes(GNode<String> node){
        return adjacencyMap.containsKey(node) ? adjacencyMap.get(node) : new LinkedList<>();
    }


    public void addVertex(GNode<String> node) {
        this.adjacencyMap.put(node, new LinkedList<GNode<String>>());
    }

    public static Graph getSampleGraph() {
        Graph graph = new Graph(true);
        graph.addEdge(new GNode<String>("1"), new GNode<String>("2"));
        graph.addEdge(new GNode<String>("1"), new GNode<String>("3"));
        graph.addEdge(new GNode<String>("2"), new GNode<String>("3"));
        graph.addEdge(new GNode<String>("4"), new GNode<String>("1"));
        graph.addEdge(new GNode<String>("4"), new GNode<String>("5"));
        graph.addEdge(new GNode<String>("5"), new GNode<String>("6"));
        graph.addEdge(new GNode<String>("6"), new GNode<String>("4"));
        return graph;
    }

    public static void main(String[] args) {
        Graph graph = getSampleGraph();
        System.out.println(graph.toString());
        System.out.println(graph.hasEdge(new GNode<String>("1"), new GNode<String>("2")));
        System.out.println(graph.hasEdge(new GNode<String>("3"), new GNode<String>("5")));

    }


}
