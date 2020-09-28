package main.java.coding.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrupleSumToTarget {

    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> quadruplet = new ArrayList<>();
        for(int i =0;i < arr.length -3;i++) {
            if (i > 0 && arr[i] == arr[i - 1]) // skip same element to avoid duplicate
                continue;
            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) //skip the same element to avoid duplicate
                    continue;
            searchPair(arr,target,i,j,quadruplet);
            }
        }
        return quadruplet;
    }
    public static void searchPair(int[] arr, int targetSum, int first, int second, List<List<Integer>> quadruplets ){
        int left = second+1;
        int right = arr.length -1;
        while (left < right){
            int sum = arr[first] + arr[second] + arr[left] + arr[right];
            if(sum == targetSum){
                quadruplets.add(Arrays.asList(arr[first],arr[second],arr[left],arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left-1])
                    left++;
                while (left < right && arr[right] == arr[right+1])
                    right--;
            } else if(sum < targetSum)
                left++; // we need a pair with bigger sum
            else
                right--; // we need a pair with smaller sum
        }
    }
    public static void main(String[] args) {
        System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
        System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 2, 0, -1, 1, -2, 2 }, 2));
    }
}
