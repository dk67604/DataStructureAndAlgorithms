package main.java.dsa_2024.algorithms;

import java.util.*;;

class Node{
    int val;
    List<Node> neighbors;

    public Node(){
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val){
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, ArrayList<Node> neighbors){
        this.val = val;
        this.neighbors = neighbors;
    }

}
public class CloneGraph {

    public Node cloneGraph(Node node){
        if(node == null){
            return null;
        }
        Map<Node, Node> vertexMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        vertexMap.put(node, new Node(node.val, new ArrayList<>()));
        while (!queue.isEmpty()) {
            Node v = queue.poll();
            for(Node neighbor: v.neighbors){
                if(!vertexMap.containsKey(neighbor)){
                    vertexMap.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }
                vertexMap.get(v).neighbors.add(vertexMap.get(neighbor));
            }
        }
        return vertexMap.get(node);
    }

}
