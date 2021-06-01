package main.java.topcodingquestion.arraysandstrings;
//https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithSumZero {
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 13};
        LargestSubArrayWithSumZero largestSubArrayWithSumZero = new LargestSubArrayWithSumZero();
        System.out.println(largestSubArrayWithSumZero.maxLen(arr));
        arr = new int[]{1, 2, 3};
        System.out.println(largestSubArrayWithSumZero.maxLen(arr));

    }

    public int maxLen(int[] nums) {
        Map<Integer, Integer> indexLookup = new HashMap<>();
        int maxLen = 0;

        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (nums[i] == 0 && maxLen == 0) {
                maxLen = 1;
            }
            if (currSum == 0) {
                maxLen = i + 1;
            }
            if (indexLookup.containsKey(currSum)) {
                maxLen = Math.max(maxLen, i - indexLookup.get(currSum));
            } else {
                indexLookup.put(currSum, i);
            }
        }
        return maxLen;
    }
}
