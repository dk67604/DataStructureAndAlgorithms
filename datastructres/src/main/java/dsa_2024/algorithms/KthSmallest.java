package main.java.dsa_2024.algorithms;

import java.util.PriorityQueue;

public class KthSmallest {

    public int findKthSmallestNumber(int[] nums, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1,n2) -> n2-n1);
        for(int i =0; i< k ; i++){
            maxHeap.add(nums[i]);
        }
        for(int i = k; i < nums.length; i++){
            if(nums[i] < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        KthSmallest kthSmallest = new KthSmallest();
        int[] nums1 = { 1, 5, 12, 2, 11, 5 };
        System.out.println(kthSmallest.findKthSmallestNumber(nums1, 3));

    }

}
