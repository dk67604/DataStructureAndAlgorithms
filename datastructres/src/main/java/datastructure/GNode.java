package main.java.datastructure;

import java.util.LinkedList;

public class GNode {
    public State state;
    String name;
    int n;
    int incomingEdges;
    LinkedList<GNode> adjacentNodes;

    public GNode(String name, int n) {
        this.name = name;
        this.n = n;
        this.incomingEdges = 0;
        this.state = State.Unvisited;
        this.adjacentNodes = new LinkedList<>();
    }

    public void addEdge(GNode node) {
        this.adjacentNodes.add(node);
        this.incomingEdges++;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public boolean equals(Object obj) {
        GNode node = (GNode) obj;
        return this.name.equals(node.name) && this.n == node.n;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + n;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());

        return hash;
    }
}
