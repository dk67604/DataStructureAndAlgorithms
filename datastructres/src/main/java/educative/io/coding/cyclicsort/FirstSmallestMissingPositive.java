package main.java.educative.io.coding.cyclicsort;

public class FirstSmallestMissingPositive {
    public static int findNumber(int[] nums){
        int i = 0;
        while (i < nums.length){
            // ignore all the numbers that are out of range of the array
            // i.e. all negative numbers and all numbers greater than or
            // equal to kength of the array
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] -1]){
                swap(nums, i, nums[i] -1);
            }
            else {
                i++;
            }
        }
        for(i =0; i< nums.length;i++){
            if(nums[i] != i+1)
                return i+1;
        }
        return nums.length + 1;
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        System.out.println(FirstSmallestMissingPositive.findNumber(new int[] { -3, 1, 5, 4, 2 }));
        System.out.println(FirstSmallestMissingPositive.findNumber(new int[] { 3, -2, 0, 1, 2 }));
        System.out.println(FirstSmallestMissingPositive.findNumber(new int[] { 3, 2, 5, 1 }));
    }
}
