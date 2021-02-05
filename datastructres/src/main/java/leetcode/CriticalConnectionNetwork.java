package main.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
There are n servers numbered from 0 to n-1 connected by undirected server-to-server
connections forming a network where connections[i] = [a, b]
represents a connection between servers a and b.
Any server can reach any other server directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some server unable to reach some other server.

Return all critical connections in the network in any order.
 */
public class CriticalConnectionNetwork {
    // We record the timestamp that we visit each node.
    // For each node, we check every neighbor except its parent
    // and return a smallest timestamp in all its neighbors.
    // If this timestamp is strictly less than the node's timestamp,
    // we know that this node is somehow in a cycle.
    // Otherwise, this edge from the parent to this node is a critical connection


    int time=0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer>[] graph =new ArrayList[n];
        //Build adjacency graph
        for(int i=0; i<n; i++){
            graph[i]= new ArrayList<Integer>();
        }
        for(List<Integer> list:connections){
            graph[list.get(0)].add(list.get(1));
            graph[list.get(1)].add(list.get(0));
        }
        int[] visitedTime = new int[n]; //Store the visited time of current node
        int[] lowTime = new int[n]; //Store lowest time among the adj nodes.
        boolean[] visited = new boolean[n];//Store the status of nodes visited or not;
        dfs(0,-1,lowTime,visitedTime,visited,graph,res);
        return res;
    }

    private void dfs(int currentNode,int parent,int[] lowTime,int[] visitedTime,boolean[] visited,List<Integer>[] graph,List<List<Integer>> res){
        visited[currentNode] = true;
        visitedTime[currentNode]=lowTime[currentNode]=time++;
        for(int neighbor:graph[currentNode]){
            if(neighbor == parent) continue;
            if(!visited[neighbor]){
                dfs(neighbor,currentNode,lowTime,visitedTime,visited,graph,res);
                lowTime[currentNode] = Math.min(lowTime[currentNode],lowTime[neighbor]);
                if(visitedTime[currentNode] < lowTime[neighbor])
                    res.add(Arrays.asList(currentNode,neighbor));
            }else{
                lowTime[currentNode] = Math.min(lowTime[currentNode],visitedTime[neighbor]);

            }

        }

    }






    public static void main(String[] args) {
        CriticalConnectionNetwork criticalConnectionNetwork = new CriticalConnectionNetwork();
        List<List<Integer>> connections =new ArrayList<>();
        int n =4;
        for (int i =0; i< n;i++){
            connections.add(new ArrayList<>());
        }
        connections.get(0).add(0,0);
        connections.get(0).add(1,1);
        connections.get(1).add(0,1);
        connections.get(1).add(1,2);
        connections.get(2).add(0,2);
        connections.get(2).add(1,0);
        connections.get(3).add(0,1);
        connections.get(3).add(1,3);
        criticalConnectionNetwork.criticalConnections(n=4,connections=connections);
    }
}
