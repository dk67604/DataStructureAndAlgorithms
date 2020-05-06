package main.java.leetcode;

import java.util.*;

/*
Build a graph as adjecency list.
First pick any node and find the farthest node (lets call it far) from that node.
Now, do DFS on this far node. The distance of the farthest node from this far node is the answer.
 */
public class TreeDiameter {
    public int treeDiameter(int[][] edges) {
        if(edges.length<1) return 0;
        Map<Integer, List<Integer>> graph =new HashMap<>();
        for(int[] edge: edges){
            if(!graph.containsKey(edge[0])) graph.put(edge[0],new ArrayList<>());
            if(!graph.containsKey(edge[1]))graph.put(edge[1],new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited =new HashSet<>();
        int[] far = dfs(graph,edges[0][0],visited);
        int[] farthest=dfs(graph,far[0],visited);
        return farthest[1];

    }

    public int treeDiameter2(int[][] edges) {
        int[] dp = new int[edges.length + 1];
        int max = Integer.MIN_VALUE;
        for (int i = edges.length - 1; i >= 0; i--) {
            int[] edge = edges[i];
            int from = edge[1];
            int to = edge[0];
            max = Math.max(max, dp[from] + dp[to] + 1);
            dp[to] = Math.max(dp[to], dp[from] + 1);
        }
        return max;
    }

    private int[] dfs(Map<Integer,List<Integer>> graph,int st, Set<Integer> visited){
        visited.add(st);
        int dist =0;
        int node = st;
        for(int adj:graph.get(st)){
            if(!visited.contains(adj)){
                int [] next=dfs(graph,adj,visited);
                if(dist<next[1]+1){
                    dist=next[1]+1;
                    node=next[0];
                }

            }
        }
        visited.remove(st);
        return new int[]{node,dist};
    }

    public static void main(String[] args) {
        TreeDiameter treeDiameter = new TreeDiameter();
        int[][] edges= new int[][]{{0,1},{1,2},{2,3},{1,4},{4,5}};
        int ans = treeDiameter.treeDiameter2(edges);
        System.out.println("Diameter of the tree: "+ans);
    }
}
