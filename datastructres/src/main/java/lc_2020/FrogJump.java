package main.java.lc_2020;

import java.util.*;

public class FrogJump {
    public boolean canCross(int[] stones){
        Map<Integer, HashSet<Integer>> canReachLookUp = new HashMap<>();
        for (int stone : stones) {
            canReachLookUp.put(stone, new HashSet<>());
        }
        canReachLookUp.get(stones[0]).add(1);
        for(int i = 1; i< stones.length ;i ++){
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
