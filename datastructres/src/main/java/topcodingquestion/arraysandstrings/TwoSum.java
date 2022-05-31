package main.java.topcodingquestion.arraysandstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] findSum(int[] nums, int target){
        Map<Integer,Integer> index = new HashMap<>();
        for(int i =0;i < nums.length;i++){
            if(index.containsKey(target-nums[i])){
                return new int[]{index.get(target-nums[i]),i};
            }
            index.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,3,4};
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.findSum(nums,7)));
    }
}
