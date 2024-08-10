package main.java.dsa_2024.algorithms;

public class SubArray {
    public int numOfSubarrays(int[] arr, int k, int thershold){
        int res = 0, currSum = 0;

        for(int i =0; i< k-1;i++){
            currSum += arr[i];
        }
        for(int l = 0; l < arr.length - k + 1;l++){
            currSum += arr[l + k -1 ];
            if((currSum / k) >= thershold){
                res++;
            }
            currSum -= arr[l];
        }
        return res;
    }
}
