package main.java.leetcode.backtracking;

import java.util.HashSet;
import java.util.Set;

public class MinimumTimeToFinishJobs {
    int ret = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        assign(jobs, 0, new int[k], 0);
        return ret;
    }

    private void assign(int[] jobs, int i, int[] workloads, int preMax) {
        if (i == jobs.length) {
            ret = Math.min(ret, preMax);
            return;
        }

        Set<Integer> used = new HashSet<>();
        for (int w = 0; w < workloads.length; w++) {
            if (!used.add(workloads[w]))
                continue;
            if (workloads[w] + jobs[i] > ret)
                continue;
            workloads[w] += jobs[i];
            assign(jobs, i+1, workloads, Math.max(workloads[w], preMax));
            workloads[w] -= jobs[i];
        }
    }

    public static void main(String[] args) {
        int[] jobs = {3,2,3};
        int k = 3;
        MinimumTimeToFinishJobs minimumTimeToFinishJobs = new MinimumTimeToFinishJobs();
        System.out.println(minimumTimeToFinishJobs.minimumTimeRequired(jobs,k));
    }
}
