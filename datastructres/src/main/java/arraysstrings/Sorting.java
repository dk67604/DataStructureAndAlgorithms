package main.java.arraysstrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Sorting {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 4, 5};
        Sorting sorting = new Sorting();
//        nums = sorting.sort(nums);
//        for (int i: nums){
//            System.out.print(i);
//        }
        nums = new int[]{2, 3, 1, 4, 5, 5, 3, 3, 2};
        List<Integer> result = sorting.sortII(nums);
        System.out.println(result);
    }

    public int[] sort(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (nums[left] < nums[right]) {
                right--;
            }
            swap(nums, left, right);
            left++;
        }
        return nums;
    }

    public List<Integer> sortII(int[] nums) {
        Map<Integer, Integer> frequencyMap = new TreeMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            while (entry.getValue() > 0) {
                result.add(entry.getKey());
                frequencyMap.put(entry.getKey(), frequencyMap.get(entry.getKey()) - 1);
            }
        }
        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
