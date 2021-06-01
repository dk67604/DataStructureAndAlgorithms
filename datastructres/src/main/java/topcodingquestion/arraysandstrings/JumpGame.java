package main.java.topcodingquestion.arraysandstrings;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (reachable < i) { //if reachable is less then current index than we can never reach
                return false;
            }
            reachable = Math.max(reachable, nums[i] + i);
        }
        return true;
    }
}
