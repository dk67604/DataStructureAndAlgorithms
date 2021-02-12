package main.java.educative.io.coding.topkelements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximumDistinctElements {
    public static int findMaximumDistinctElements(int[] nums, int k) {
        int distinctElementsCount = 0;
        if (nums.length <= k) {
            return distinctElementsCount;
        }
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        for (int i : nums) {
            numFrequencyMap.put(i, numFrequencyMap.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());
        // insert all numbers with frequency greater than '1' into the min-heap
        for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                distinctElementsCount++;
            } else {
                minHeap.add(entry);
            }
        }
        // following a greedy approach, try removing the least frequent numbers first from the min-heap
        while (k > 0 && !minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            // to make an element distinct, we need to remove all of its occurrences except one
            k -= entry.getValue() - 1;
            if (k >= 0) {
                distinctElementsCount++;
            }
        }
        if (k > 0)
            distinctElementsCount -= k;
        return distinctElementsCount;
    }

    public static void main(String[] args) {
        int result = MaximumDistinctElements.findMaximumDistinctElements(new int[]{7, 3, 5, 8, 5, 3, 3}, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[]{3, 5, 12, 11, 12}, 3);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[]{1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5}, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);
    }
}
