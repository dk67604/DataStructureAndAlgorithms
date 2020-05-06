package main.java.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.

If there is no non-empty subarray with sum at least K, return -1.



Example 1:

Input: A = [1], K = 1
Output: 1
Example 2:

Input: A = [1,2], K = 4
Output: -1
Example 3:

Input: A = [2,-1,2], K = 3
Output: 3

 */
public class SubArrayWithSumAtLeastK {

    public int shortestSubarray(int[] A, int K) {
        int len =A.length;
        int ans =Integer.MAX_VALUE;
        int[] prefixSum = new int[len+1];
        for(int i=0;i<len;i++){
            prefixSum[i+1]=prefixSum[i]+A[i];
        }
        Deque<Integer> deque =new ArrayDeque<>();
        for(int i=0;i<len+1;i++){
            while (!deque.isEmpty() && prefixSum[i]-prefixSum[deque.peekFirst()]>=K){
                ans =Math.min(ans,i-deque.peekFirst());
                deque.pollFirst();
            }
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekLast()]<=0){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }

    public static void main(String[] args) {
     int[] nums = new int[]{2,-1,2,1}  ;
     int K= 3;
     SubArrayWithSumAtLeastK subArrayWithSumAtLeastK =new SubArrayWithSumAtLeastK();
        System.out.println(subArrayWithSumAtLeastK.shortestSubarray(nums,K));
    }
}
