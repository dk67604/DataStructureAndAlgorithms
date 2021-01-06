package main.java.educative.io.coding.topkelements;

import java.util.*;

public class TaskScheduler {
    public static int scheduleTasks(char[] tasks, int k) {
        int intervalCount = 0;
        Map<Character,Integer> taskFrequencyMap = new HashMap<>();
        for(char ch : tasks){
            taskFrequencyMap.put(ch, taskFrequencyMap.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((e1,e2) -> e2.getValue() - e1.getValue());
        maxHeap.addAll(taskFrequencyMap.entrySet());


        while (!maxHeap.isEmpty()){
            int n = k+1;
            List<Map.Entry<Character,Integer>> waitList = new ArrayList<>();
            for(;n>0 && !maxHeap.isEmpty(); n--){
                intervalCount++;
                Map.Entry<Character,Integer> currentEntry = maxHeap.poll();
                if(currentEntry.getValue() > 1){
                    currentEntry.setValue(currentEntry.getValue() -1);
                    waitList.add(currentEntry);
                }
            }
            maxHeap.addAll(waitList);
            if(!maxHeap.isEmpty()){
                intervalCount +=n;// we'll be having 'n' idle intervals for the next iteration
            }
        }

        return intervalCount;
    }
    public static void main(String[] args) {
        char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));

        tasks = new char[] { 'a', 'b', 'a' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));
    }

    }
