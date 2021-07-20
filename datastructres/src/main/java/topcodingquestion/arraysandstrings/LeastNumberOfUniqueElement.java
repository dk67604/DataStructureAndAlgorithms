package main.java.topcodingquestion.arraysandstrings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNumberOfUniqueElement {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int a : arr) {
            countMap.put(a, countMap.getOrDefault(a, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> countMap.get(a) - countMap.get(b));
        for (int key : countMap.keySet()) minHeap.offer(key);
        while (k > 0 && !minHeap.isEmpty()) {
            k -= countMap.get(minHeap.poll());
        }
        return k < 0 ? minHeap.size() + 1 : minHeap.size();
    }
}
