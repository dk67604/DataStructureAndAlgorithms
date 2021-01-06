package main.java.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {

    public int connectSticks(int[] sticks){
        int cost =0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int stick : sticks){
            minHeap.add(stick);
        }
        while (minHeap.size() > 1){
            int sum = minHeap.remove() + minHeap.remove(); // pick first two smallest stick
             cost += sum;
             minHeap.add(sum);
        }
        return cost;
    }
}
