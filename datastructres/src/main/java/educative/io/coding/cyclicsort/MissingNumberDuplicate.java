package main.java.educative.io.coding.cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class MissingNumberDuplicate {

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        if (nums == null || nums.length == 0) return missingNumbers;

        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) missingNumbers.add(j + 1);
        }
        return missingNumbers;
    }

    public static void main(String[] args) {
        List<Integer> missing = MissingNumberDuplicate.findNumbers(new int[]{2, 3, 1, 8, 2, 3, 5, 1});
        System.out.println("Missing numbers: " + missing);

        missing = MissingNumberDuplicate.findNumbers(new int[]{2, 4, 1, 2});
        System.out.println("Missing numbers: " + missing);

        missing = MissingNumberDuplicate.findNumbers(new int[]{2, 3, 2, 1});
        System.out.println("Missing numbers: " + missing);
    }
}
