package main.java.topcodingquestion.arraysandstrings;

/*
 * We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
 * The array originally contained all the numbers from 1 to ‘n’, but due to a data error,
 * one of the numbers got duplicated which also resulted in one number going missing.
 * Find both these numbers.
 */
public class FindCorruptNums {
    public static int[] findNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return new int[]{-1, -1};
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = FindCorruptNums.findNumbers(new int[]{3, 1, 2, 5, 2});
        System.out.println(nums[0] + ", " + nums[1]);
        nums = FindCorruptNums.findNumbers(new int[]{3, 1, 2, 3, 6, 4});
        System.out.println(nums[0] + ", " + nums[1]);
    }
}
