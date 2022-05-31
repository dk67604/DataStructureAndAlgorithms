package main.java.topcodingquestion.arraysandstrings;

import java.util.ArrayList;
import java.util.List;
/**
ou are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are in the inclusive range.

A number x is considered missing if x is in the range [lower, upper] and x is not in nums.

Return the smallest sorted list of ranges that cover every missing number exactly. That is, no element of nums is in any of the ranges, and each missing number is in one of the ranges.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
 


*/
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
