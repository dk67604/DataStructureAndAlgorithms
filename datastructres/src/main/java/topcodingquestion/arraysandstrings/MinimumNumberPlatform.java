package main.java.topcodingquestion.arraysandstrings;

import java.util.Arrays;

public class MinimumNumberPlatform {
    public static int platformNeeded(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int platform = 1;
        int result = 1;
        int i = 1, j = 0;
        // Similar to merge in
        //merge sort to process
        //all events in sorted order
        while (i < arr.length && j < dep.length) {
            //If next event in sorted
            //order is arrival,
            //increment count of
            //platforms needed
            if (arr[i] <= dep[j]) {
                platform++;
                i++;

            } else if (arr[i] > dep[j]) {
                platform--;
                j++;
            }
            // Update result if needed
            if (platform > result)
                result = platform;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        int n = arr.length;
        System.out.println("Minimum Number of Platforms Required = "
                + platformNeeded(arr, dep));
    }
}
