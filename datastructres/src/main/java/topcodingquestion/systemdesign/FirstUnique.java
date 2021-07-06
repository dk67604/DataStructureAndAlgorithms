package main.java.topcodingquestion.systemdesign;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/first-unique-number/solution/
public class FirstUnique {
    Queue<Integer> queue;
    Map<Integer, Boolean> isUnique;

    public FirstUnique(int[] nums) {
        queue = new LinkedList<>();
        isUnique = new HashMap<>();
        for (int num : nums) {
            this.add(num);
        }

    }

    public int showFirstUnique() {
        // We need to start by "cleaning" the queue of any non-uniques at the start.
        // Note that we know that if a value is in the queue, then it is also in
        // isUnique, as the implementation of add() guarantees this.
        while (!queue.isEmpty() && !isUnique.get(queue.peek())) {
            queue.remove();
        }
        // Check if there is still a value left in the queue. There might be no uniques.
        if (!queue.isEmpty()) {
            return queue.peek();
        }
        return -1;

    }

    public void add(int value) {
        // Case 1: We need to add the number to the queue and mark it as unique.
        if (!isUnique.containsKey(value)) {
            isUnique.put(value, true);
            queue.add(value);
        }
        // Case 2 and 3: We need to mark the number as no longer unique.
        else {
            isUnique.put(value, false);
        }
    }
}
