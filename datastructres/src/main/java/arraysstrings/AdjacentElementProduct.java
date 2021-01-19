package main.java.arraysstrings;

import java.util.PriorityQueue;

public class AdjacentElementProduct {
    public static int largestAdjacentProductPair(int[] nums){
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2) -> n2-n1);
        for (int i =1 ;i<nums.length;i++){
            pq.offer(nums[i-1]*nums[i]);
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,6,-2,-5,7,3};
        System.out.println(AdjacentElementProduct.largestAdjacentProductPair(nums));
    }
}
