package main.java.leetcode;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b) ->(b-a));
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if(maxHeap.size()<minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
       return maxHeap.size()>minHeap.size()?maxHeap.peek():(maxHeap.peek()+minHeap.peek())*0.5;
    }
}
