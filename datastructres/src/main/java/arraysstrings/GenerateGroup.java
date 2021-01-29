package main.java.arraysstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateGroup {
    public static void main(String[] args) {
        int[] nums = {3, 2, 11, 1, 12, 6, 4};
        int t = 2;
        GenerateGroup solution = new GenerateGroup();
        System.out.println(solution.genearteGroupWithThersholdT(nums, t));

    }

    public List<List<Integer>> genearteGroupWithThersholdT(int[] nums, int thershold) {


        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        Arrays.sort(nums);
        List<Integer> tempList = new ArrayList<>();
        tempList.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] - tempList.get(tempList.size() - 1)) <= thershold) {
                tempList.add(nums[i]);

            } else {
                result.add(new ArrayList<>(tempList));
                tempList.clear();
                tempList.add(nums[i]);

            }


        }
        result.add(tempList);
        return result;

    }
}
