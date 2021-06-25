package main.java.topcodingquestion.arraysandstrings;

//https://leetcode.com/problems/next-permutation/
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //Finding first decreasing element
        while (i >= 0 && nums[i + 1] > nums[i]) {
            i--;
        }
        //Find the element on right side which is greater then element at current index i
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
