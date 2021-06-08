package main.java.topcodingquestion.treesandgraphs;

import java.util.*;

public class ConnectedSum {
    public int connectedSum(int n, List<String> edges) {
        if (n <= 1)
            return n;
        //Create adjacency list
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        Set<Integer> zeroEdges = new HashSet<>();
        for (String edge : edges) {
            String[] e = edge.split(" ");
            map.get(Integer.parseInt(e[0])).add(Integer.parseInt(e[1]));
            map.get(Integer.parseInt(e[1])).add(Integer.parseInt(e[0]));
        }
        //perform dfs from each node if it is not visited
        Set<Integer> visited = new HashSet<>();
        int result = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 0) {
                result += 1;
                zeroEdges.add(entry.getKey());
            }
        }
        for (int i = 1; i <= n; i++) {
            if (visited.add(i) && !zeroEdges.contains(i)) {
                List<Integer> nodes = new ArrayList<>();
                nodes.add(i);
                dfsVisit(i, map, visited, nodes);
                result += Math.ceil(Math.sqrt(nodes.size()));

            }
        }

        return result;
    }

    private void dfsVisit(int i, Map<Integer, List<Integer>> map, Set<Integer> visited, List<Integer> nodes) {
        for (int j : map.get(i)) {
            if (visited.add(j)) {
                nodes.add(j);
                dfsVisit(j, map, visited, nodes);
            }
        }
    }
}
