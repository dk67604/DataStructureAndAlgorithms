package main.java.topcodingquestion.treesandgraphs;

import java.util.*;

public class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (vertices <= 0) {
            return sortedOrder;
        }
        //a. Initialize the graph
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }
        //b. Build the graph
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0], child = edges[i][1];
            graph.get(parent).add(child);//put the child into it's parent's list
            inDegree.put(child, inDegree.get(child) + 1);
        }
        //c. Find all source i.e all the vertices with 0 in-degree
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }
        //d. For each source, add it to the sortedOrder and subtract one from all of its
        // children's in-degree,
        // if a child's in-degree becomes zero, add it to the sources queue
        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            sortedOrder.add(vertex);
            List<Integer> children = graph.get(vertex);
            for (int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    sources.offer(child);
                }
            }
        }
        if (sortedOrder.size() != vertices)
            return new ArrayList<>();
        return sortedOrder;
    }

    public static void main(String[] args) {
        List<Integer> result = TopologicalSort.sort(4,
                new int[][]{new int[]{3, 2}, new int[]{3, 0}, new int[]{2, 0}, new int[]{2, 1}});
        System.out.println(result);

        result = TopologicalSort.sort(5, new int[][]{new int[]{4, 2}, new int[]{4, 3}, new int[]{2, 0},
                new int[]{2, 1}, new int[]{3, 1}});
        System.out.println(result);

        result = TopologicalSort.sort(7, new int[][]{new int[]{6, 4}, new int[]{6, 2}, new int[]{5, 3},
                new int[]{5, 4}, new int[]{3, 0}, new int[]{3, 1}, new int[]{3, 2}, new int[]{4, 1}});
        System.out.println(result);
    }
}
