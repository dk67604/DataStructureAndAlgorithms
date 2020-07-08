package main.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result=new ArrayList<>();
		Arrays.sort(nums);
		helper(result,new ArrayList<Integer>(),0,nums);
		return result;
		
	}
	
	public void helper(List<List<Integer>> result,List<Integer> templist,int start,int[] nums) {
		result.add(new ArrayList<>(templist));
		for(int i=start;i<nums.length;i++) {
			if(i>start && nums[i]==nums[i-1]) continue; //avoid duplicate
			templist.add(nums[i]);
			helper(result,templist,i+1,nums);
			templist.remove(templist.size()-1);
		}
	}
}
