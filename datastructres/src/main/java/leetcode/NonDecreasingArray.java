package main.java.leetcode;

public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;                                                                    //the number of changes
        for(int i = 1; i < nums.length && cnt<=1 ; i++){
            if(nums[i-1] > nums[i]){
                cnt++;
                if(i-2<0 || nums[i-2] <= nums[i])nums[i-1] = nums[i];                    //modify nums[i-1] of a priority
                else nums[i] = nums[i-1];                                                //have to modify nums[i]
            }
        }
        return cnt<=1;
    }

    public boolean checkPossibility2(int[] nums) {
        // corner case
        if(nums == null || nums.length <= 1) return true;

        // the count of continuous non-decreasing sub-array
        int count = 1;
        int index = 0;

        int n = nums.length;
        for(int i = 1; i < n; i++){
            if(nums[i] < nums[i - 1]){
                index = i;
                count++;
            }
        }

        if(count == 1) return true;
        if(count == 2){
            // if the discord happens at start or end position, we can modify
            // it to match the condition
            if(index == 1 || index == n - 1) return true;

            // if in the middle, we modify nums[index - 2]
            // index - 2, (index - 1, index) , index + 1
            if(nums[index + 1] >= nums[index - 1] || nums[index] >= nums[index - 2]) {
                return true;
            }
            return false;
        }

        return false;
    }

    public static void main(String[] args) {
        NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();
        System.out.println(nonDecreasingArray.checkPossibility2(new int[]{-1,4,2,3}));
    }
}
