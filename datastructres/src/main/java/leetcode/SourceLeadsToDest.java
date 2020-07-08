package main.java.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SourceLeadsToDest {

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        //Create adjacency list
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int[] edge : edges ){
            graph.putIfAbsent(edge[0],new HashSet<>());
            graph.get(edge[0]).add(edge[1]);
        }
        return dfs(graph, new boolean[n],source,destination);
    }

    private boolean dfs(Map<Integer,Set<Integer>> graph, boolean[] visited, int curr, int end){
        if(!graph.containsKey(curr)) return curr == end;
        visited[curr] = true;
        for(int neighbor : graph.get(curr)){
            if(visited[neighbor] || !dfs(graph,visited,neighbor,end)) {
                return false;
            }
        }
        visited[curr]=false;
        return true;
    }

    public static void main(String[] args) {
        int[][] edges =  {{0,1},{0,2}};
        int n= 3;
        int source =0;
        int destination = 1;
        SourceLeadsToDest sourceLeadsToDest = new SourceLeadsToDest();
        System.out.println(sourceLeadsToDest.leadsToDestination(3,edges,source,destination));
    }
}
