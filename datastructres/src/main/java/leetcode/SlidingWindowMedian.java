package main.java.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // size of the median array is equal to difference of length of array and sliding window size
        double[] res= new double[nums.length-k+1];
        int j=0;
        for(int i=0;i<nums.length;i++){

            //balance the heap
            maxHeap.add(nums[i]);
            minHeap.add(maxHeap.poll());
            if(maxHeap.size()<minHeap.size()){
                maxHeap.add(minHeap.poll());
            }

            if(maxHeap.size()+minHeap.size()==k){
                if (maxHeap.size() == minHeap.size()){
                    res[j]=(double)((long)maxHeap.peek()+(long)minHeap.peek())/2;
                }else{
                    res[j]=maxHeap.peek();
                }
                // Adjust sliding window,remove last element of previous window
                if(!maxHeap.remove(nums[j]))
                    minHeap.remove(nums[j]);
                j++;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {2147483647,1,2,3,4,5,6,7,2147483647};
        int k=2;
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        System.out.println(Arrays.toString(slidingWindowMedian.medianSlidingWindow(nums,k)));
    }
}
