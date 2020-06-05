package main.java.arraysstrings;

public class CountTriplets {
    /*
     * Given an array of distinct positive integers arr[] of length N,
     * the task is to count all the triplets such that sum of two elements equals the third element.
     */
    public int countTriplets(int[] nums){
        int[] freqs = new int[100];
        for (int i =0; i<nums.length;i++){
            freqs[nums[i]]++;
        }
        int count =0;
        for (int i =0;i<nums.length;i++){
            for (int j = i+1;j<nums.length;j++){
                if(freqs[nums[i]+nums[j]] >0){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = {1, 5, 3, 2};
        CountTriplets countTriplets = new CountTriplets();
        System.out.println(countTriplets.countTriplets(nums));
    }
}
