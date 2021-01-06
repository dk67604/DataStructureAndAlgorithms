package main.java.educative.io.coding.topkelements;

import java.util.PriorityQueue;

public class KthLargestNumberInStream {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int k =0;

    public KthLargestNumberInStream(int[] nums, int k) {
        this.k = k;
        for(int i = 0;i< nums.length; i++){
            add(nums[i]);
        }
    }

    public int add(int num) {
        minHeap.add(num);
        if(minHeap.size() > this.k){
            minHeap.poll();
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
        KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6));
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));
        System.out.println("4th largest number is: " + kthLargestNumber.add(4));
    }
}
