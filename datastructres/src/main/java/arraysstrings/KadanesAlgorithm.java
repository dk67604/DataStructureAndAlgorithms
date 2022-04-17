package main.java.arraysstrings;
/*
 * Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
 */
public class KadanesAlgorithm {

    public int subArrayMaxSum(int [] nums){
        int max_global = nums[0];
        int max_current = nums[0];
        for (int i =1; i < nums.length; i++){
            //Max_current is max sum of subarray ends at current index
            max_current = Math.max(nums[i],max_current+nums[i]);
            max_global = Math.max(max_current,max_global);
        }
        return max_global;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,-2,5};
        KadanesAlgorithm kadanesAlgorithm = new KadanesAlgorithm();
        System.out.println(kadanesAlgorithm.subArrayMaxSum(nums));
    }
}
