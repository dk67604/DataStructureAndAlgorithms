package main.java.leetcode.backtracking;

import java.util.*;

public class PermutationII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // count the occurrence of each number
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int num: nums){
            countMap.put(num, countMap.getOrDefault(num,0)+1);
        }
        LinkedList<Integer> comb = new LinkedList<>();
        backtrack(comb,nums.length,countMap,result);
        return result;
    }

    private void backtrack(LinkedList<Integer> comb,int length,Map<Integer,Integer> countMap,List<List<Integer>> result){
        if(comb.size() == length){
            // make a deep copy of the resulting permutation,
            // since the permutation would be backtracked later.
            result.add(new ArrayList<Integer>(comb));
            return;
        }
        for(Map.Entry<Integer,Integer> entry : countMap.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            if(count == 0)
                continue;
            comb.add(num);
            countMap.put(num,count-1);
            //continue the exploration
            backtrack(comb,length,countMap,result);
            //revert the choice for the next exploration
            comb.removeLast();
            countMap.put(num,count);
        }
    }

    public static void main(String[] args) {

        PermutationII permutationII = new PermutationII();
        int[] nums = {1,1,2,2};
        System.out.println("Here are all the permutations: " + permutationII.permuteUnique(nums));
    }
}
