package main.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallest {
    private int partition(int[] array,int low, int high){
        int i = low -1;
        int j = low;
        int pivot = array[high];

        for (j=low;j<high;j++){
            if(array[j]<pivot){
                i++;

                // swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Place the pivot at right place
        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;
        return i+1;
    }

    public  int kthSmallest(int[] arr, int l,
                                  int r, int k)
    {
        // If k is smaller than number of elements
        // in array
        if (k > 0 && k <= r - l + 1) {
            // Partition the array around last
            // element and get position of pivot
            // element in sorted array
            int pos = partition(arr, l, r);

            // If position is same as k
            if (pos - l == k - 1)
                return arr[pos];

            // If position is more, recur for
            // left subarray
            if (pos - l > k - 1)
                return kthSmallest(arr, l, pos - 1, k);

            // Else recur for right subarray
            return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
        }

        // If k is more than number of elements
        // in array
        return Integer.MAX_VALUE;
    }

    public int kthSmallestusingMinHeap(List<Integer> nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nums);
        //pop exactly k-1 times
        while (--k > 0){
            pq.poll();
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        int [] array = {12, 3, 5, 7, 4, 19, 26};
        int k =3;
        KthSmallest kthSmallest = new KthSmallest();
        System.out.println(kthSmallest.kthSmallest(array,0,array.length-1,k));
        List<Integer> list = new ArrayList<>();
        for(int a:array){
            list.add(a);
        }
        System.out.println(kthSmallest.kthSmallestusingMinHeap(list,3));

    }
}
