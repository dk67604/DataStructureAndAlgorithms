package main.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestValueColorInDAG {
    public int largestPathValue(String colors, int[][] edges) {
        int vertices = colors.length();
        Map<Integer, List<Integer>> graph = new HashMap<>();//graph
        Map<Integer, Integer> inDegree = new HashMap<>();// in-degree

        //Ini
        for (int i = 0; i < vertices; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }
        return 0;
    }
}
