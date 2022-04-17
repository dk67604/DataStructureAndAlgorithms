package main.java.topcodingquestion.sortingandsearching;

import java.util.Arrays;

public class MergeSort {
    public int[] mergeTwoSortedArray(int[] a, int[] b){
        int m = a.length;
        int n = b.length;
        int[] res = new int[n+m];
        int i =0, j=0,k=0;
        while (i< m && j < n){
            if(a[i] < b[j]){
                res[k] = a[i];
                i++;
            }
            else {
                res[k] = b[j];
                j++;
            }
            k++;
        }
        while (i < m){
            res[k] = a[i];
            i++;
            k++;
        }
        while (j < n){
            res[k] = b[j];
            j++;
            k++;
        }
        return res;
    }

    private int[] mergeSortHelper(int[] nums, int lo, int hi){
        if (lo == hi){
            return new int[]{nums[lo]};
        }
        int mid = (lo + hi) /2;
        int[] fhs = mergeSortHelper(nums, lo, mid);
        int[] shs = mergeSortHelper(nums,mid +1,hi);
        return mergeTwoSortedArray(fhs,shs);

    }

    public int[] mergeSort(int[] nums){
        return mergeSortHelper(nums,0,nums.length-1);
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] nums = new int[]{8,5,1,3,7,2,9,6,4};
        System.out.println(Arrays.toString(mergeSort.mergeSort(nums)));
    }
}
