package main.java.leetcode;

import java.util.PriorityQueue;

public class MinimumNumberOfRefuelingStops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        //MaxHeap to store capacities of gas station
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int ans = 0, prev = 0;
        for (int[] station : stations) {
            int location = station[0];
            int capacity = station[1];
            startFuel -= location - prev;
            while (!maxHeap.isEmpty() && startFuel < 0) {
                startFuel += maxHeap.poll();
                ans++;
            }
            if (startFuel < 0) return -1;
            maxHeap.offer(capacity);
            prev = location;
        }
        // calculate fuel for last trip
        startFuel -= target - prev;
        while (!maxHeap.isEmpty() && startFuel < 0) {
            startFuel += maxHeap.poll();
            ans++;
        }
        if (startFuel < 0) return -1;
        return ans;
    }
}
