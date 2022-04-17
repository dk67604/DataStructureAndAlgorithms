package main.java.topcodingquestion.sortingandsearching;


import java.util.Arrays;

public class QuickSort {
    private int partition(int[] nums, int pivot, int lo, int hi){
        int i = lo, j =lo;
        while (i <= hi){
            if(nums[i] <= pivot){
                swap(nums, i, j);
                i++;
                j++;
            }else {
                i++;
            }
        }
        return j-1;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void quickSortHelper(int[] nums,int lo, int hi){
        if(lo >= hi){
            return;
        }
        int pivot = nums[hi];
        int pi = partition(nums,pivot,lo,hi);
        quickSortHelper(nums, lo,pi-1);
        quickSortHelper(nums,pi+1,hi);
    }
    public int[] quickSort (int[] nums){
        quickSortHelper(nums,0, nums.length-1);
        return nums;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = new int[]{8,5,1,3,7,2,9,6};
        System.out.println(Arrays.toString(quickSort.quickSort(nums)));
    }
}
