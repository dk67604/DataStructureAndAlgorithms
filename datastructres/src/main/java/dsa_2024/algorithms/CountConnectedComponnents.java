package main.java.dsa_2024.algorithms;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;


public class CountConnectedComponnents {

    public int countComponents(int n, int[][] edges){
        HashMap<Integer,List<Integer>> adj = new HashMap<>();
        init(adj, edges, n);
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                count++;
                dfs(adj, i, visited);
            }
        }
        return count;
    }
    private void dfs(HashMap<Integer, List<Integer>> adj, int index, boolean[] visited){
        visited[index] = true;
        for(Integer j: adj.get(index)){
            if(visited[j] == false){
                dfs(adj, index, visited);
            }
        }
    }

    private void init(HashMap<Integer, List<Integer>> adj, int[][] edges, int n){
        for(int i = 0; i < n ; i++){
            adj.put(i, new LinkedList<>());
        }
        for(int i = 0; i < edges.length ; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
    }

}
