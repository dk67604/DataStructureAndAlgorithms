package main.java.leetcode;

import java.util.*;

public class TaskScheduler {
        public int leastInterval(char[] tasks, int n) {
            Map<Character,Integer> map = new HashMap<>();
            for(char c: tasks){
                map.put(c,map.getOrDefault(c,0)+1);
            }
            //MaxHeap
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
            pq.addAll(map.values());

            int cycle =0;
            while (!pq.isEmpty()){
                List<Integer> temp = new ArrayList<>();
                for(int i =0;i<n+1;i++){
                    if (!pq.isEmpty()){
                        temp.add(pq.remove());
                    }
                }
                for (int i :temp){
                    if(--i>0){
                        pq.add(i);
                    }
                }
                // increment our return value by either the size of the temporary list
                // (i.e. all the tasks you were able to run) or by the cooldown time
                // (if you ran out of tasks to run you have to wait the full cooldown).
                // Finally, once the max heap is empty, return cycles.
                cycle+=pq.isEmpty()?temp.size():n+1;
            }
            return cycle;
        }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n =0;
        TaskScheduler taskScheduler = new TaskScheduler();
        System.out.println(taskScheduler.leastInterval(tasks,2));

    }
}
