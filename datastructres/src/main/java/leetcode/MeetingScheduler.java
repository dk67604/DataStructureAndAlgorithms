package main.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Use two pointer approach
 */
public class MeetingScheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);//sort based on start time;
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        int i = 0, j = 0;
        int n1 = slots1.length, n2 = slots2.length;
        while (i < n1 && i < n2) {
            // Find intersect between slots1[i] and slots2[j]
            int intersectStart = Math.max(slots1[i][0], slots2[j][0]);
            int intersectEnd = Math.min(slots1[i][1], slots2[j][1]);
            if (intersectStart + duration <= intersectEnd) {
                return Arrays.asList(intersectStart, intersectStart + duration);
            } else if (slots1[i][1] < slots2[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return new ArrayList<>();
    }
}
