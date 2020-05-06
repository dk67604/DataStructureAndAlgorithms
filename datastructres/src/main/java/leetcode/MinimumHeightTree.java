package main.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTree {
	public void initializaGraph(int[] incEdges,List<List<Integer>> adjList,int[][] prerequisites) {
		int size=incEdges.length;
		while(--size>=0)adjList.add(new ArrayList<>());
		for(int[] edge:prerequisites ) {
			incEdges[edge[0]]++;
			incEdges[edge[1]]++;
			adjList.get(edge[1]).add(edge[0]);
			adjList.get(edge[0]).add(edge[1]);
		}
	}
	
	public List<Integer> findMinHeightTrees(int n, int[][] edges){
		List<List<Integer>> adjList=new ArrayList<>();
		int[] incEdges=new int[n];
		initializaGraph(incEdges, adjList, edges);
		List<Integer> res = new ArrayList<Integer>();
		if (n==1) {
			res.add(0);
			return res;
		}
		Queue<Integer> queue=new LinkedList<>();
		for(int i=0;i<n;i++) {
			if(incEdges[i]==1)
				queue.offer(i);
		}
		while(!queue.isEmpty()) {
			res=new ArrayList<>();
			int count=queue.size();
			for(int i=0;i<count;i++) {
				int curr=queue.poll();
				res.add(curr);
				incEdges[curr]--;
				for(int k=0;k<adjList.get(curr).size();k++) {
					int next=adjList.get(curr).get(k);
					if(incEdges[next]==0)continue;
					if(incEdges[next]==2)queue.offer(next);
					incEdges[next]--;
				}
			}
		}
		return res;
	}
}
