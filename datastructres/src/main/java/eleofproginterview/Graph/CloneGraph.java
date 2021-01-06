package main.java.eleofproginterview.Graph;

import java.util.*;

public class CloneGraph {
    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Map<Node,Node> vertexGraph = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        vertexGraph.put(node,new Node(node.val,new ArrayList<>()));
        while (!queue.isEmpty()){
            Node v = queue.poll();
            for(Node e : v.neighbors){
                //try to copy vertex
                if(!vertexGraph.containsKey(e)){
                    vertexGraph.put(e,new Node(e.val,new ArrayList<>()));
                    queue.add(e);
                }
                //copy the edge
                vertexGraph.get(v).neighbors.add(vertexGraph.get(e));
            }
        }
        return vertexGraph.get(node);
    }
}
