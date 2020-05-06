package main.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company has is the one with headID.

Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also it's guaranteed that the subordination relationships have a tree structure.

The head of the company wants to inform all the employees of the company of an urgent piece of news. He will inform his direct subordinates and they will inform their subordinates and so on until all employees know about the urgent news.

The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e After informTime[i] minutes, all his direct subordinates can start spreading the news).

Return the number of minutes needed to inform all the employees about the urgent news.
 */
public class TimeNeeded1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(i,new ArrayList<>());

        }
        for(int i=0;i<n;i++){
            if(manager[i]!=-1) graph.get(manager[i]).add(i);
        }

        Queue<int[]> queue =new LinkedList<>();
        queue.offer(new int[] {headID,0});
        int ans =0;
        while (!queue.isEmpty()){
            int[] top =queue.poll();
            int m=top[0],i=top[1];
            ans=Math.max(ans,i);
            for(int next:graph.get(m)){
                queue.offer(new int[]{next,i+informTime[m]});
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TimeNeeded1376 timeNeeded1376 = new TimeNeeded1376();
        /*
        Test Case: n:  6
                   headId: 2
                   manager: [2,2,-1,2,2,2]
                    informTime: [0,0,1,0,0,0]
         */
        int ans=timeNeeded1376.numOfMinutes(6,2,new int[]{2,2,-1,2,2,2},new int []{0,0,1,0,0,0});
        System.out.println(ans);
    }
}
