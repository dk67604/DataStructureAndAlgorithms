package main.java.dsa_2024.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] cand, int start, int target, List<Integer> tempList,
        List<List<Integer>> result){
            if(target < 0){
                return;
            }
            if (target == 0){
                result.add(new ArrayList<>(tempList));
            }
            for(int i = start; i < cand.length; i++){
                tempList.add(cand[i]);
                backtrack(cand, i, target - cand[i], tempList, result);
                tempList.remove(tempList.size() - 1);
            }
        }

}
