package main.java.topcodingquestion.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/maximum-units-on-a-truck/
public class MaximumUnitOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        maxHeap.addAll(Arrays.asList(boxTypes));
        int unitCount = 0;
        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            int boxCount = Math.min(truckSize, top[0]);
            unitCount += boxCount * top[1];
            truckSize -= boxCount;
            if (truckSize == 0)
                break;
        }
        return unitCount;
    }
}
