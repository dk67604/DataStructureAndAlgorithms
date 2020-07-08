package main.java.leetcode;
import java.util.*;
public class FindDuplicate {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> ans = new ArrayList<>();
		for(int i =0;i<nums.length;i++){
			if(nums[Math.abs(nums[i])-1]<0) {//seen before
				ans.add(Math.abs(nums[i]));
			}
			nums[Math.abs(nums[i])-1]*=-1;
		}
		return ans;
	}
	  public static void main(String[] args) {
		int nums[]=new int[] {4,3,2,7,8,2,3,1};
		FindDuplicate findDuplicate=new FindDuplicate();
		System.out.println(findDuplicate.findDuplicates(nums));
	}
}
