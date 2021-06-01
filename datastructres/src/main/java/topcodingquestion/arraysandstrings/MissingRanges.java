package main.java.topcodingquestion.arraysandstrings;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int prev = Integer.MIN_VALUE;
        List<String> result = new ArrayList<>();
        for (int num : nums) {
            if (prev == Integer.MIN_VALUE && prev == num)
                continue;
            if (num == lower) {
                lower += 1;
            } else {
                result.add(helper(lower, num - 1));
                lower = num + 1;
            }
            prev = num;
        }
        // check if list ends but max range is not yet reached
        // last num should not be max range
        // last num should be less than max range
        int num = lower - 1;
        if (num != upper && num < upper) {
            result.add(helper(num + 1, upper));
        }
        return result;
    }

    private String helper(int v1, int v2) {
        if (v1 == v2) {
            return String.valueOf(v1);
        } else
            return "v1" + "->" + v2;
    }
}
