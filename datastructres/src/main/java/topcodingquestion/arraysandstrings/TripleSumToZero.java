package main.java.topcodingquestion.arraysandstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripleSumToZero {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) //skip duplicate
                continue;
            searchPair(arr, i + 1, -arr[i], triplets);
        }
        return triplets;
    }

    private static void searchPair(int[] arr, int left, int targetSum, List<List<Integer>> triplets) {
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum) {
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1])
                    left++;
                while (left < right && arr[right] == arr[right + 1])
                    right--;
            } else if (targetSum > currentSum)
                left++;
            else
                right--;
        }

    }

    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        System.out.println(searchTriplets(new int[]{-5, 2, -1, -2, 3}));
    }
}
