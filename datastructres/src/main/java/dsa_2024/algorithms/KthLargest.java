package main.java.dsa_2024.algorithms;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k =0;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<Integer>();
        this.k = k;
        for(int num : nums){
            add(num);
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size() > k){
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {4,5,8,2};
        KthLargest kthLargest = new KthLargest(3, nums);
        System.out.println(kthLargest.add(3));
    }

}
