package main.java.topcodingquestion.arraysandstrings;

//https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
public class SmallestDivisor {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = (int) 1e6;
        while (left < right) {
            int mid = (left + right) / 2, sum = 0;
            for (int a : nums) {
                sum += (a + mid - 1) / mid;
            }
            if (sum > threshold) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
