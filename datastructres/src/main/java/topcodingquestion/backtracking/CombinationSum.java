package main.java.topcodingquestion.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), target, candidates, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, ArrayList<Integer> tempList, int target, int[] candidates, int start) {
        if (target < 0)
            return;
        if (target == 0)
            result.add(new ArrayList<Integer>(tempList));
        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            backtrack(result, tempList, target - candidates[i], candidates, i);
            tempList.remove(tempList.size() - 1);
        }

    }
}
