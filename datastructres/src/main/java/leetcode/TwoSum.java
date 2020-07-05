package main.java.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public boolean hasArrayTwoCandidate(int A[],int target) {
		int length=A.length;
		Arrays.sort(A);
		int l=0;int r=length-1;
		while(l<r) {
			if(A[l]+A[r]==target)
				return true;
			else if(A[l]+A[r]<target)
				l++;
			else
				r--;
		}
		return false;
	}

	public int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<>();
		int complement =0;
		for (int i =0;i<nums.length;i++){
			complement = target-nums[i];
			if(map.containsKey(complement)){
				return new int[]{map.get(complement),i};
			}
			map.put(nums[i],i);
		}
		return new int[]{-1,-1};
	}
	
	public static void main(String[] args) {
		TwoSum twoSum=new TwoSum();
		System.out.println(twoSum.hasArrayTwoCandidate(new int[] {1, 4, 45, 6, 10, -8}, 52));
	}

}
