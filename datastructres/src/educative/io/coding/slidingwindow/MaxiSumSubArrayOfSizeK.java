package educative.io.coding.slidingwindow;

/**
 * Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
 */
public class MaxiSumSubArrayOfSizeK {

    public static int findMaxSumSubArray(int k, int[] arr) {
       int windowSum =0;
       int windowStart =0;
       int maxWindowSum = Integer.MIN_VALUE;
       for (int windowEnd =0 ; windowEnd<arr.length;windowEnd++){
           windowSum += arr[windowEnd]; // add the next element
           //slide the window, sliding isn't required if we don't hit the size of window k
           if(windowEnd>=k-1){
               maxWindowSum = Math.max(windowSum,maxWindowSum);
               windowSum -= arr[windowStart]; // subtract the element out of the window
               windowStart++; // slide the window ahead
           }
       }
       return maxWindowSum;
    }
}
