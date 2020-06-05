package main.java.arraysstrings;

import java.util.*;

public class SubArrayWithGivenSum {

    public int[] subArraySum(int[] nums,int sum){
            int n = nums.length;
            int start =0;
            List<int[]> res = new ArrayList<>();
            int currSum =nums[0];
            for (int i =1; i<=n;i++){
                // If the running sum exceeds the expected sum than remove the first element
                // from the sub-array
                while (currSum > sum && start < i-1){
                    currSum = currSum - nums[start];
                    start++;
                }
                // Add the index when running sum equals expected sum
                if(currSum == sum){
                    int p = i-1;
                    res.add(new int[]{start,p});

                }
                if(i<n){
                    currSum+=nums[i];
                }
            }
            // Additional logic to check the minimum length of sub-array among
        // all possible sequences expected
            int len = Integer.MAX_VALUE;
            int index =0;
            for (int i =0;i<res.size();i++){
                int[] p = res.get(i);
//                System.out.println(Arrays.toString(p));
                int temp = Math.abs(p[0] - p[1]);
                if(temp<len){
                    len = temp;
                    index =i;
                }
            }
            return  res.size()>0?res.get(index): new int[]{};
    }

    //Version 2 with negative element allowed
    public int [] subArraySumWithNegative(int[] nums,int sum){
        int n = nums.length;
        int currentSum=0;
        int start = 0;
        int end = -1;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i< n;i++){
            currentSum+= nums[i];
            if(currentSum - sum == 0){
                start =0;
                end =i;
                break;
            }
            if(map.containsKey(currentSum - sum)){
                start = map.get(currentSum-sum) +1;
                end=i;
                break;
            }
            map.put(currentSum,i);
        }
        return new int[]{start,end};
    }

    public static void main(String[] args) {
        int [] nums1 = {1,2,3,7,5};
        int sum1 = 12;
        SubArrayWithGivenSum subArrayWithGivenSum = new SubArrayWithGivenSum();
        System.out.println(Arrays.toString(subArrayWithGivenSum.subArraySum(nums1,sum1)));
        int [] nums2 = {1,2 ,3, 4, 5, 6, 7, 8, 9, 10};
        int sum2 = 15;
        System.out.println(Arrays.toString(subArrayWithGivenSum.subArraySum(nums2,sum2)));
        int nums3[] = {15, 2, 4, 8, 9, 5, 10, 23};
        int sum3 = 23;
        System.out.println(Arrays.toString(subArrayWithGivenSum.subArraySum(nums3,sum3)));
        int nums4[] = {10, 2, -2, -20, 10};
        int sum4 = -10;
        System.out.println(Arrays.toString(subArrayWithGivenSum.subArraySumWithNegative(nums4,sum4)));





    }
}
