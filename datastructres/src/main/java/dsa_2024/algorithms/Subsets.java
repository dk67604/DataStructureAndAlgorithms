package main.java.dsa_2024.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(ans, 0, nums, list);
        return ans;
    }

    public void helper(
        List<List<Integer>> ans,
        int start,
        int[] nums,
        List<Integer> list
    )
    {
        if(start >= nums.length){
            ans.add(new ArrayList<>());
        }else{
            list.add(nums[start]);
            helper(ans, start + 1, nums, list);
            list.remove(list.size() - 1);
            helper(ans, start + 1, nums, list);
        }
    }

    public List<List<Integer>> subsetIterative(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int currentNum: nums){
            int n = result.size();
            for(int i = 0; i < n; i++){
              List<Integer> set = new ArrayList<>(result.get(i));
              set.add(currentNum);
              result.add(set);
            }
        }
        return result;
    }
}
