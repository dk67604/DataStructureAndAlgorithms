package main.java.topcodingquestion.arraysandstrings;

//https://leetcode.com/problems/partition-array-into-disjoint-intervals/
public class PartitionArrayIntoDisjointInterval {
    public int partitionDisjoint(int[] nums) {
        int localMax = nums[0], partitionIdx = 0, max = localMax;
        for (int i = 1; i < nums.length; i++) {
            if (localMax > nums[i]) {
                localMax = max;
                partitionIdx = i;
            } else {
                max = Math.max(max, nums[i]);
            }
        }
        return partitionIdx + 1;
    }
}
