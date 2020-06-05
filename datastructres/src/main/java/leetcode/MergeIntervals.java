package main.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <=1)return intervals;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval: intervals){
            if(interval[0]<=newInterval[1]){//Overlapping interval, mve the end if needed
                newInterval[1] = Math.max(interval[1],newInterval[1]);

            }
            else {//Disjoint interval, add the interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        for (int[] a:mergeIntervals.merge(intervals)){
            System.out.println(Arrays.toString(a));
        }

    }
}
