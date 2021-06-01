package main.java.topcodingquestion.arraysandstrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//https://leetcode.com/problems/frog-jump/
public class FrogJumps {
    //Using DFS
    public boolean canCross(int[] stones) {
        for (int i = 3; i < stones.length; i++) {
            if (stones[i] > stones[i - 1] * 2) {
                return false;
            }
        }
        Set<Integer> stonePositions = new HashSet<>();
        for (int stone : stones) {
            stonePositions.add(stone);
        }
        Stack<Integer> positions = new Stack<>();
        Stack<Integer> jumps = new Stack<>();
        positions.add(0);
        jumps.add(0);
        int lastPosition = stones[stones.length - 1];
        while (!positions.isEmpty()) {
            int position = positions.pop();
            int jumpDistance = jumps.pop();
            for (int i = jumpDistance - 1; i <= jumpDistance + 1; i++) {
                if (i <= 0) {
                    continue;// we don't want to move backward
                }
                int nextPosition = position + i;
                if (nextPosition == lastPosition) {
                    return true;
                } else if (stonePositions.contains(nextPosition)) {
                    positions.add(nextPosition);
                    jumps.add(i);
                }
            }
        }

        return false;

    }

    // Using Dynamic Programming
    public boolean canCrossDP(int[] stones) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }
}
