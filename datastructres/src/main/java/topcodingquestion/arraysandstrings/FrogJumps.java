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
        Map<Integer, HashSet<Integer>> canReachLookUp = new HashMap<>();
        for (int stone : stones) {
            canReachLookUp.put(stone, new HashSet<>());
        }
        canReachLookUp.get(stones[0]).add(1);
        for(int i = 0; i< stones.length ;i ++){
            int currStone = stones[i];
            HashSet<Integer> jumps = canReachLookUp.get(stones[i]);
            for (int jump : jumps){
                int pos = currStone + jump;
                if (pos == stones[stones.length -1]) return true;
                if(canReachLookUp.containsKey(pos)){
                    if(jump - 1 > 0){
                        canReachLookUp.get(pos).add(jump - 1);
                    }
                    canReachLookUp.get(pos).add(jump);
                    canReachLookUp.get(pos).add(jump + 1);
                }
            }
        }
        return false;
    }
}
