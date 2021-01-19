package main.java.leetcode;
// This question is exactly same as trapping rain water
public class FindMaxSnowflake {

    public static int findMaxSnowflake(int[] nums){
        int left_max =0, right_max = 0;
        int left =0, right = nums.length-1;
        int totalWater =0;
        while (left < right){
            if(nums[left] < nums[right]){
                if(nums[left] >= left_max){
                    left_max = nums[left];
                }
                else {
                    totalWater += left_max - nums[left];
                }
                left++;
            }
            else {
                if(nums[right] >=right_max){
                    right_max = nums[right];
                }
                else {
                    totalWater += right_max - nums[right];
                }
                right--;

            }
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,3,0,1,2,0,4,2,0,3,0};
        System.out.println(FindMaxSnowflake.findMaxSnowflake(nums));
    }
}
