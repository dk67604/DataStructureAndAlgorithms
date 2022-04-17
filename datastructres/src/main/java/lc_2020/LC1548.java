package main.java.lc_2020;

import java.util.*;

public class LC1548 {
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        Map<Integer,List<Integer>> graph = buildGraph(n, roads);
        int[][] nextChoiceForMin = new int[names.length][targetPath.length];
        int[][] visited = new int[names.length][targetPath.length];
        for (int[] x : visited) Arrays.fill(x,-1);
        int min = Integer.MAX_VALUE;
        int start =0;
        for(int i =0; i< names.length;i++){
            int resp =  dfs(i,0,nextChoiceForMin,visited,names,targetPath,graph);
            if(resp < min){
                min = resp;
                start =i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (ans.size() < targetPath.length){
            ans.add(start);
            start = nextChoiceForMin[start][ans.size()-1];
        }
        return ans;
    }

    private Map<Integer, List<Integer>> buildGraph(int n, int[][] roads){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        //Initialize graph,remember this graph is undirected graph
        for(int i =0; i<n;i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] road : roads){
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        return graph;
    }

    private int dfs(int nameIdx, int currPathIdx, int[][] nextChoiceForMin, int[][] visited,String[] names,
                    String[] targetPath,Map<Integer,List<Integer>> graph){
        if (visited[nameIdx][currPathIdx] !=-1) return visited[nameIdx][currPathIdx];
        //if it's different, add 1 else add 0.
        int editDist = (names[nameIdx].equals(targetPath[currPathIdx]))?0 :1;
        //if path is filled, we're done
        if(currPathIdx == targetPath.length-1) return editDist;
        //for each neighbor, calculate min cost and save the city that gives the min cost
        int min = Integer.MAX_VALUE;
        for (int neighbor : graph.get(nameIdx)){
            int neighborCost = dfs(neighbor,currPathIdx+1,nextChoiceForMin, visited,
                    names,targetPath,graph);
            if (neighborCost < min){
                min = neighborCost;
                nextChoiceForMin[nameIdx][currPathIdx] = neighbor;
            }
        }
        editDist +=min; //Update minimum distance
        visited[nameIdx][currPathIdx] = editDist; //save the min cost when we visited
        return editDist;
    }
}
