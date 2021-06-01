package main.java.topcodingquestion.arraysandstrings;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[]{start + 1, end + 1};
            } else if (numbers[start] + numbers[end] > target) {
                end -= 1;
            } else {
                start += 1;
            }
        }
        return new int[2];
    }
}
