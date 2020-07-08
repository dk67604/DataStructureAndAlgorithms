package main.java.leetcode;

import java.util.Arrays;

public class KthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l =0;
        int r = nums[n-1] - nums[0];
        while(l<r){
            int j = 0;
            int count = 0;
            int m = (l+r)/2;
            for(int i=0;i<n;i++){
                while(j<n && nums[j] - nums[i] <=m) j++;
                count+=j-i-1;
            }
            if(count<k) l = m+1;
            else r =m;
        }
        return l;
    }

    public static void main(String[] args) {
        KthSmallestPairDistance kthSmallestPairDistance = new KthSmallestPairDistance();
        System.out.println(kthSmallestPairDistance.smallestDistancePair(new int[]{1,3,5,7,10},3));
    }
}
