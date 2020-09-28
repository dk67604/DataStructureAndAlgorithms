package main.java.coding.twopointers;

import java.util.Arrays;

/**
 * Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet. If there are more than one such triplet, return the sum of the triplet with the smallest sum.
 *
 * Example 1:
 *
 * Input: [-2, 0, 1, 2], target=2
 * Output: 1
 * Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
 * Example 2:
 *
 * Input: [-3, -1, 1, 2], target=1
 * Output: 0
 * Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
 * Example 3:
 *
 * Input: [1, 0, 1, 1], target=100
 * Output: 3
 * Explanation: The triplet [1, 1, 1] has the closest sum to the target.
 */
public class TripletSumCloseToTarget {
    public static int searchTriplet(int[] arr, int targetSum) {
        if(arr == null || arr.length <3)
            throw  new IllegalArgumentException();
        Arrays.sort(arr);
        int smallestDifference = Integer.MAX_VALUE;
        for (int i =0; i< arr.length - 2; i++){
            int left = i+1, right = arr.length -1;
            while (left <right){
                // comparing the sum of three numbers to the 'targetSum' can cause overflow
                // so, we will try to find a target difference
                int targetDifference = targetSum - arr[i] - arr[left] - arr[right];
                if(targetDifference ==0)
                    return targetSum - targetDifference;
                // the second part of the above 'if' is to handle the smallest sum when we have more than one solution
                if (Math.abs(targetDifference) < Math.abs(smallestDifference)
                    || (Math.abs(targetDifference) == Math.abs(smallestDifference)
                && targetDifference > smallestDifference))
                    smallestDifference = targetDifference;// save the closest and the biggest difference

                if (targetDifference > 0)
                    left++;
                else
                    right--;
            }
        }
        return targetSum - smallestDifference;
    }
    public static void main(String[] args) {
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
    }
}
