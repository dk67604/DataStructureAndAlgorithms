package main.java.topcodingquestion.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[]{1, 2, -1, 3, 5}, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[]{1, 2, -1, 3, 5}, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }

    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (maxheap.size() == 0 || maxheap.peek() >= nums[i]) {
                maxheap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            }
            reBalanceHeap();
            if (i - k + 1 >= 0) {// if we have at least 'k' elements in the sliding window
                if (maxheap.size() == minHeap.size()) {
                    // we have even number of elements, take the average of middle two elements
                    result[i - k + 1] = maxheap.peek() / 2.0 + minHeap.peek() / 2.0;
                } else {// because max-heap will have one more element than the min-heap
                    result[i - k + 1] = maxheap.peek();
                }

                //remove the element going out of sliding window
                int elementToBeRemoved = nums[i - k + 1];
                if (elementToBeRemoved <= maxheap.peek()) {
                    maxheap.remove(elementToBeRemoved);
                } else {
                    minHeap.remove(elementToBeRemoved);
                }
                reBalanceHeap();
            }
        }
        return result;
    }

    private void reBalanceHeap() {
        if (maxheap.size() > minHeap.size() + 1) {
            minHeap.add(maxheap.poll());
        } else if (maxheap.size() < minHeap.size()) {
            maxheap.add(minHeap.poll());
        }
    }
}
