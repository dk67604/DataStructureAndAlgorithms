package main.java.leetcode.backtracking;

import java.util.*;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(candidates);
        backtrack(candidates,0,target,new ArrayList<Integer>(),result);
        return new ArrayList<>(result);
    }

    private void backtrack(int[] cand, int start,int target, List<Integer> tempList,
                           Set<List<Integer>> result){
        if(target<0){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(tempList));
        }
        for(int i =start; i< cand.length; i++){
            if(i > start && cand[i] == cand[i-1]) continue; // skip duplicates
            tempList.add(cand[i]);
            backtrack(cand,i+1,target-cand[i],tempList,result);
            tempList.remove(tempList.size() - 1);
        }
    }
}
