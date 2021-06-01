package main.java.leetcode.arrays;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPoint {
    public static void main(String[] args) {
        int[] a = {0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
        KClosestPoint kClosestPoint = new KClosestPoint();
        System.out.println(kClosestPoint.findClosestElements(a, 3, 5));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            if (maxHeap.size() < k) {
                maxHeap.add(new Pair(arr[i], Math.abs(x - arr[i])));
            } else {
                if (maxHeap.peek().diff > Math.abs(arr[i] - x)) {
                    maxHeap.poll();
                    maxHeap.add(new Pair(arr[i], Math.abs(arr[i] - x)));
                }
            }
        }
        while (maxHeap.size() > 0) {
            result.add(maxHeap.poll().value);
        }
        Collections.sort(result);
        return result;
    }

    class Pair implements Comparable<Pair> {
        int value;
        int diff;

        public Pair(int value, int diff) {
            this.value = value;
            this.diff = diff;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.diff == o.diff) {
                return this.value - o.value;
            } else {
                return this.diff - o.diff;
            }
        }
    }
}
