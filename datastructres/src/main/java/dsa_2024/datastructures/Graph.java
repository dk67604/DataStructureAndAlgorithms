package main.java.dsa_2024.datastructures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Graph {
    private final Map<GNode<String>, LinkedList<GNode<String>>> adjacencyMap;
    boolean directed;

    public Graph(boolean directed){
        this.directed = directed;
        this.adjacencyMap = new HashMap<>();
    }

    public Map<GNode<String>, LinkedList<GNode<String>>> getAdjacencyMap(){
        return this.adjacencyMap;
    }

}
