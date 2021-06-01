package main.java.topcodingquestion.arraysandstrings;

import java.util.List;

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        boolean[] mark = new boolean[24 * 60];
        for (String str : timePoints) {
            String[] t = str.split(":");
            int hour = 60 * Integer.valueOf(t[0]);
            int minutes = Integer.valueOf(t[1]);
            if (mark[hour + minutes]) return 0;
            mark[hour + minutes] = true;
        }
        int min = Integer.MAX_VALUE;
        int first = Integer.MAX_VALUE;
        int last = Integer.MIN_VALUE;
        int prev = 0;
        for (int i = 0; i < mark.length; i++) {
            if (mark[i]) {
                if (first != Integer.MAX_VALUE) {
                    min = Math.min(min, i - prev);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            }
        }
        min = Math.min(min, (24 * 60 - last + first));
        return min;
    }
}
