package main.java.topcodingquestion.arraysandstrings;

public class FirstAndLastPositionOfElement {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        res[0] = search(nums, target, false);
        if (res[0] != -1) {
            res[1] = search(nums, target, true);
        }
        return res;
    }

    private int search(int[] nums, int target, boolean findMaxIndex) {
        int start = 0;
        int end = nums.length - 1;
        int targetIndex = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                targetIndex = mid;
                if (findMaxIndex) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return targetIndex;
    }
}
