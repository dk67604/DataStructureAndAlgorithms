package main.java.leetcode.dynamicprogramming;

public class MaximumSumNonAdjacentElement {
    public static int maximumSumNonAdjacentElement(int[] nums) {
        int include = nums[0];
        int exclude = 0;
        for (int i = 1; i < nums.length; i++) {
            int newInclude = exclude + nums[i];
            int newExclude = Math.max(exclude, include);
            include = newInclude;
            exclude = newExclude;
        }
        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
        int[] nums = {5, 10, 10, 100, 5, 6};
        System.out.println(MaximumSumNonAdjacentElement.maximumSumNonAdjacentElement(nums));
    }
}
