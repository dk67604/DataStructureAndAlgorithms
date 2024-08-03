package main.java.dsa_2024.datastructures;
import java.util.LinkedList;
public class GNode<T> {
    public State state;
    T node;
    int incomingEdges;
    LinkedList<GNode<T>> adjacentNodes;

    public GNode( T node){
        this.node = node;
        this.incomingEdges = 0;
        this.state = State.Unvisited;
        this.adjacentNodes = new LinkedList<>();
    }
    public void addEdge(GNode<T> node){
        this.adjacentNodes.add(node);
        this.incomingEdges++;
    }

    @Override
    public String toString(){
        return node.toString();
    }

    public T getNode(){
        return node;
    }

    public void setNode(T node){
        this.node = node;
    }

    public State getState(){
        return this.state;
    }

    @Override
    public boolean equals(Object obj){
        GNode<?> gNode = (GNode<?>) obj;
        return this.node.equals(gNode.node);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash;
        hash = 31 * hash + (node == null ? 0 : node.hashCode());
        return hash;
    }
}
