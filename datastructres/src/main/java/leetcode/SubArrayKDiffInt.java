package main.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubArrayKDiffInt {
    // Approach to solve the problem is using sliding window. To find exact K distinct integer in sub array, use atmost K
    //distinct and atmost K-1 distinct. Subtracting the result of the two we get exactly K

    public int subarraysWithKDistinct(int[] A, int K) {

        return atMostK(A,K)- atMostK(A,K-1);
    }

    public int atMostK(int[] A,int K){
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        int distinct=0; // Count the unique number in subarray
        int res=0; // Count the total sequences
        int i=0;
        int j=0;
        int length=A.length;
        while(j<length){
            if(map.getOrDefault(A[j],0)==0) distinct++;
            map.put(A[j],map.getOrDefault(A[j],0)+1);
            j++;
            while(i<j&&distinct>K){
                map.put(A[i],map.get(A[i])-1);
                if(map.get(A[i])==0){
                    distinct--;
                }

                i++;
            }
            res+=j-i;
        }
        return res;

    }

    //Driver Method
    public static void main(String[] args) {
        //Test Case 1: A=[1,2,1,2,3] K=2 Answer:7
        // Test Case 2: A=[1,2,1,3,4] K=3 Answer:3
        int[] A={1,2,1,2,3};
        int K=2;
        SubArrayKDiffInt subArrayKDiffInt=new SubArrayKDiffInt();
        int result=subArrayKDiffInt.subarraysWithKDistinct(A,K);
        System.out.println(result);
    }

}
