package main.java.topcodingquestion.sortingandsearching;

public class MinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int res = nums[0];
        int left =0, right = nums.length -1;
        while(left<=right){
            if(nums[left] < nums[right]){
                res = Math.min(res, nums[left]);
                break;
            }
            int mid = left + (right - left)/2;
            res = Math.min(res,nums[mid]);
            if(nums[left] <= nums[mid]){
                left = mid + 1;
            }else{
                right = mid -1;
            }

        }
        return res;
    }
}
