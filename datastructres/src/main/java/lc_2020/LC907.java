package main.java.lc_2020;

import java.util.Stack;

/**
 * https://leetcode.com/problems/sum-of-subarray-minimums/
 * Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [3,1,2,4]
 * Output: 17
 * Explanation:
 * Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
 * Sum is 17.
 * Example 2:
 *
 * Input: arr = [11,81,94,43,3]
 * Output: 444
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 3 * 104
 * 1 <= arr[i] <= 3 * 104
 */
public class LC907 {
    // Use approach of monotonically increasing stack
    public int sumSubarrayMins(int[] A){
        Stack<int[]> previousLess = new Stack<>();
        Stack<int[]> nextLess = new Stack<>();
        int[] leftDistance = new int[A.length];
        int[] rightDistance = new int[A.length];
        for (int i = 0; i< A.length;i++){
            // >= to deal with duplicate elements
            while (!previousLess.isEmpty() && previousLess.peek()[0] >= A[i]) previousLess.pop();
            leftDistance[i] = previousLess.isEmpty() ? i+1 : i - previousLess.peek()[1];
            previousLess.push(new int[]{A[i],i});
        }
        for (int i = A.length-1; i>=0;i--){
            while (!nextLess.isEmpty() && nextLess.peek()[0] > A[i]) nextLess.pop();
            rightDistance[i] = nextLess.isEmpty() ? A.length -i : nextLess.peek()[1] -i;
            nextLess.push(new int[]{A[i],i});
        }
        long ans = 0;
        long mod = (long) 1e9 + 7;
        for(int i=0; i<A.length; i++)
        {
            ans = (ans + (long)A[i] * leftDistance[i] * rightDistance[i]) % mod;
        }
        return (int)ans;
    }
}
