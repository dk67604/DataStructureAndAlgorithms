package main.java.leetcode;
import java.util.*;
public class CourseScheduleII {

	/*
	 * Creating Adjacency List, in this list we map pre-requisite with their dependent course
	 */
	public void initializaGraph(int[] incEdge,List<List<Integer>> adjList,int[][] prerequisites) {
		int size=incEdge.length;
		while(--size>=0)adjList.add(new ArrayList<>());
		for(int[] edge:prerequisites ) {
			incEdge[edge[0]]++;
			adjList.get(edge[1]).add(edge[0]);
		}
	}
	
	private int[] topologicalSort(int[]incEdges,List<List<Integer>> adjList) {
		int[] order=new int[incEdges.length];
		Queue<Integer> queue=new LinkedList<>();
		for(int i=0;i<incEdges.length;i++) {
			if(incEdges[i]==0)queue.offer(i);
		}
		int visited=0;
		while(!queue.isEmpty()) {
			int from=queue.poll();
			order[visited++]=from;
			for(int to:adjList.get(from)) {
				incEdges[to]--;
				if(incEdges[to]==0)queue.offer(to);
			}
		}
		return visited==incEdges.length?order:new int[0];
		
	}
	
	public int[] findOrder(int numCourses,int[][]prerequisites) {
		int[] incEdges=new int[numCourses];
		List<List<Integer>> adjList=new ArrayList<>();
		initializaGraph(incEdges, adjList, prerequisites);
		System.out.println(adjList.size());
		return topologicalSort(incEdges, adjList);
	}
	public static void main(String[] args) {
		int[][] prerequisites=new int[][] {{1,0}};
		int numCourses=2;
		CourseScheduleII courseScheduleII=new CourseScheduleII();
		System.out.println(Arrays.toString(courseScheduleII.findOrder(numCourses, prerequisites)));
	}
}
