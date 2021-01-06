package main.java.arraysstrings;

import main.java.leetcode.PairSum;

import java.util.HashMap;
import java.util.Map;

public class PairSums {
    int numberOfWays(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length ; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int twice_count =0;
        for(int i =0; i< arr.length ;i++){
            if(map.containsKey(k-arr[i])){
                twice_count += map.get(k-arr[i]);
            }
            if((k-arr[i]) == arr[i]){
                twice_count--;
            }
        }
        return twice_count/2;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 5, 7, -1, 5} ;
        PairSums pairSums = new PairSums();
        System.out.println(pairSums.numberOfWays(arr,6));
    }
}
