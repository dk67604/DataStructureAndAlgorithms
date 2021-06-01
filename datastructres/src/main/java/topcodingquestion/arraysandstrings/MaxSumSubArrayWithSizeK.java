package main.java.topcodingquestion.arraysandstrings;

/*
 * Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
 */
public class MaxSumSubArrayWithSizeK {
    public static int findMaxSumSubArray(int k, int[] nums) {
        int windowStart = 0;
        int maxSum = 0;
        int windowSum = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2}));
        System.out.println("Maximum sum of a subarray of size K: "
                + findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5}));
    }
}
