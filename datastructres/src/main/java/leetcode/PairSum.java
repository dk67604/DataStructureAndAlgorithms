package main.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class PairSum {

	public static boolean checkPairSumExist(int[] nums,int target) {
		Map<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			int complement=target-nums[i];
			if(map.containsKey(complement))
				return true;
			map.put(nums[i], i);
		}
		return false;
	}
	public static void main(String[] args) {
		int[] nums=new int[] {10,15,3,9};
		int target=17;
		System.out.println(checkPairSumExist(nums, target));
	}
}
