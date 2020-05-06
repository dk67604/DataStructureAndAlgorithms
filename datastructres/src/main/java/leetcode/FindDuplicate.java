package main.java.leetcode;
import java.util.*;
public class FindDuplicate {
	  public List<Integer> findDuplicates(int[] nums) {
	        Set<Integer> set=new HashSet<>();
	        for(int i=0;i<nums.length;i++){
	            int index= Math.abs(nums[i])-1;
	            if(nums[index]<0){
	                set.add(Math.abs(index+1));
	            }
	            else{
	                nums[index]=-nums[index];
	            }
	        }
	      
	        return new ArrayList<>(set);
	    }
	  public static void main(String[] args) {
		int nums[]=new int[] {4,3,2,7,8,2,3,1};
		FindDuplicate findDuplicate=new FindDuplicate();
		System.out.println(findDuplicate.findDuplicates(nums));
	}
}
