package main.java.topcodingquestion.arraysandstrings;

/*
Initiate the maximum position that one could reach starting from the current index i or before: max_pos = nums[0].

Initiate the maximum position reachable during the current jump: max_steps = nums[0].

Initiate number of steps: at least one, if array has more than 1 cell.

Iterate over number of elements in the input array:

If max_step < i, one needs one more jump: jumps += 1. To minimize the number of jumps, choose the longest possible one: max_steps = max_pos.

Update max_pos = max(max_pos, i + nums[i]).

Return the number of jumps.
*/
public class JumpGameII {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        int maxSteps = nums[0];
        int maxPos = nums[0];
        int jump = 1;
        for (int i = 0; i < n; i++) {
            if (maxSteps < i) {
                ++jump;
                maxSteps = maxPos;
            }
            maxPos = Math.max(maxPos, i + nums[i]);
        }
        return jump;
    }
}
