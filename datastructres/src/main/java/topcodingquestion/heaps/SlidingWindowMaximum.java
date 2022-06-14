package main.java.topcodingquestion.heaps;

import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length ==0) return new int[]{};
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2)->n2-n1);
        for(int i =0; i<k;i++){
            maxHeap.add(nums[i]);
        }
        int len = nums.length;
        int [] result = new int[len-k+1];
        result[0] = maxHeap.peek();
        for(int i =k;i<len;i++){
            maxHeap.remove(nums[i-k]);
            maxHeap.add(nums[i]);
            result[i-k+1] = maxHeap.peek();
        }
        return result;
    }
}
