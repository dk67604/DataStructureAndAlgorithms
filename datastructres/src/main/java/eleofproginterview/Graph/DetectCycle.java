package main.java.eleofproginterview.Graph;

import java.util.List;

public class DetectCycle {
    public static class GraphVertex{
        public static enum Color {WHITE,GRAY,BLACK}

        public Color color;
        public List<GraphVertex> edges;
    }

    public static boolean isDeadLocked(List<GraphVertex> G){
        for (GraphVertex vertex : G){
            if (vertex.color == GraphVertex.Color.WHITE && hasCycle(vertex)){
                return true;
            }
        }
        return false;
    }

    private static boolean hasCycle(GraphVertex curr){
        // Visiting a gray means there is a cycle
        if(curr.color == GraphVertex.Color.GRAY){
            return true;
        }
        curr.color = GraphVertex.Color.BLACK; // Marks current vertex
        //Traverse the neighbour vertices
        for (GraphVertex next : curr.edges){
            if(next.color != GraphVertex.Color.BLACK){
                if(hasCycle(next)){
                    return true;
                }
            }
            curr.color = GraphVertex.Color.BLACK; // Marks the current vertex as black
        }
        return false;
    }
}
