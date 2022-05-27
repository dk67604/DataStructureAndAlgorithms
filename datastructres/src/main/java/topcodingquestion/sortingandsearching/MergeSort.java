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

    //CTCI
    public int[] mergesort(int[] array){
        int[] helper = new int[array.length];
        mergesort(array,helper,0,array.length-1);
        return array;
    }

    private void  mergesort(int[] array, int[] helper, int low, int high){
        if(low < high){
            int middle = (low + high)/2;
            mergesort(array,helper,low, middle);
            mergesort(array,helper, middle +1, high);
            merge(array,helper,low,middle,high);
        }
    }
    private void merge(int[] array, int[] helper, int low, int middle, int high){
        /*Copy both halved into helper*/
        for(int i = low; i <= high; i++){
            helper[i] = array[i];
        }
        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;
        /* Iterate throught the helper array/ Compare the left and right half, copying back
        * the smaller element from the two halves into the original array*/
        while (helperLeft <=middle && helperRight<=high){
            if(helper[helperLeft] <= helper[helperRight]){
                array[current] = helper[helperLeft];
                helperLeft++;
            }else {
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }
        // copy the rest of the left side of array into the target array
        int remaining = middle - helperLeft;
        for (int i =0;i<=remaining;i++){
            array[current+i] = helper[helperLeft+i];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] nums = new int[]{8,5,1,3,7,2,9,6,4};
        System.out.println(Arrays.toString(mergeSort.mergeSort(nums)));
        nums = new int[]{3,1,2};
        System.out.println(Arrays.toString(mergeSort.mergesort(nums)));
    }
}
