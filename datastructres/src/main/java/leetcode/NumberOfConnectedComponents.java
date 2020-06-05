package main.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfConnectedComponents {

    public static void main(String[] args) {
        NumberOfConnectedComponents numberOfConnectedComponents = new NumberOfConnectedComponents();
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        int n = 5;
        System.out.println(numberOfConnectedComponents.countComponentsusinUnion(n, edges));
        System.out.println(numberOfConnectedComponents.countComponentsUsingDFS(n, edges));
        System.out.println(numberOfConnectedComponents.countComponentsUsingBFS(n,edges));
    }

    // Approach 1 Using Find
    private int findParent(int[] roots, int id) {
        while (roots[id] != id) {
            roots[id] = roots[roots[id]];//Path Compression
            id = roots[id];
        }
        return id;
    }

    public int countComponentsusinUnion(int n, int[][] edges) {
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i; //Assign rank to each node
        }
        //Perform union if the root doesn't belong to same component
        for (int[] edge : edges) {
            int root1 = findParent(roots, edge[0]);
            int root2 = findParent(roots, edge[1]);
            if (root1 != root2) {
                roots[root1] = root2;
                n--;
            }
        }
        return n;
    }

    //using DFS
    public int countComponentsUsingDFS(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int components = 0;
        boolean[] visited = new boolean[n];
        for (int v = 0; v < n; v++) components += dfs(graph, v, visited);
        return components;
    }

    private int dfs(List<Integer>[] graph, int u, boolean[] visited) {
        if (visited[u]) return 0;
        visited[u] = true;
        for (int v : graph[u]) {
            dfs(graph, v, visited);
        }
        return 1;
    }

    public int countComponentsUsingBFS(int n, int[][] edges) {
        List<Integer> [] graph = new List[n];
        for (int i =0; i<n;i++) graph[i] = new ArrayList<>();
        for (int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int components =0;
        for (int v = 0; v<n;v++) components+=bfs(graph,v,visited);
        return components;
    }

    private int bfs(List<Integer> [] graph,int u, boolean[] visited){
        if(visited[u]) return 0;
        visited[u] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(u);
        while (!queue.isEmpty()){
            int t = queue.poll();
            for (int v:graph[t]){
                if(!visited[v]){
                    visited[v] =true;
                    queue.offer(v);
                }
            }
        }
        return 1;
    }
}
