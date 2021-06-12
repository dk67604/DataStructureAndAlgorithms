package main.java.topcodingquestion.dynamicprogramming;


import java.util.Arrays;
import java.util.Comparator;

//https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/WeightedJobSchedulingMaximumProfit.java
class Job {
    int start;
    int end;
    int profit;

    public Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}

class FinishTimeComparator implements Comparator<Job> {

    @Override
    public int compare(Job o1, Job o2) {
        if (o1.end <= o2.end) {
            return -1;
        } else {
            return 1;
        }
    }
}

/**
 * Sort the jobs by finish time.
 * For every job find the first job which does not overlap with this job
 * and see if this job profit plus profit till last non overlapping job is greater
 * than profit till last job.
 */

public class MaximumProfitInJobScheduling {
    public static void main(String[] args) {
        int[] startTime = new int[]{3, 6, 7, 9};
        int[] endTime = new int[]{5, 8, 8, 12};
        int[] profit = new int[]{6, 5, 3, 4};
        MaximumProfitInJobScheduling maximumProfitInJobScheduling = new MaximumProfitInJobScheduling();
        //Output is 15
        System.out.println(maximumProfitInJobScheduling.jobScheduling(startTime, endTime, profit));
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[startTime.length];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        int[] T = new int[startTime.length];
        FinishTimeComparator finishTimeComparator = new FinishTimeComparator();
        Arrays.sort(jobs, finishTimeComparator);
        T[0] = jobs[0].profit;
        for (int i = 1; i < jobs.length; i++) {
            T[i] = Math.max(jobs[i].profit, T[i - 1]);
            for (int j = i - 1; j >= 0; j--) {
                if (jobs[j].end <= jobs[i].start) {
                    T[i] = Math.max(T[i], jobs[i].profit + T[j]);
                    break;
                }
            }
        }
        int maxVal = Integer.MIN_VALUE;
        for (int val : T) {
            if (maxVal < val) {
                maxVal = val;
            }
        }
        return maxVal;
    }
}
