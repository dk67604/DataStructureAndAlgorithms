package main.java.leetcode;
import java.util.*;
public class CointainsDuplicateIII {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	    TreeSet<Integer> set = new TreeSet<>();
	    for (int i = 0; i < nums.length; ++i) {
	        // Find the successor of current element
	        Integer s = set.ceiling(nums[i]);
	        if (s != null && s <= nums[i] + t) return true;

	        // Find the predecessor of current element
	        Integer g = set.floor(nums[i]);
	        if (g != null && nums[i] <= g + t) return true;

	        set.add(nums[i]);
	        if (set.size() > k) {
	            set.remove(nums[i - k]);
	        }
	    }
	    return false;
	}
	
	public static void main(String[] args) {
		CointainsDuplicateIII cointainsDuplicateIII=new CointainsDuplicateIII();
		int [] nums=new int[] {1,5,9,1,5,9};
		cointainsDuplicateIII.containsNearbyAlmostDuplicate(nums, 2, 3);
	}
}
