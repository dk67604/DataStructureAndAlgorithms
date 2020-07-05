package main.java.leetcode;

import java.util.PriorityQueue;

public class KthLargest {

    //Approach 1: Using MinHeap
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n:nums){
            pq.add(n);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();

    }
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

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //Approach2: QuicSelect
    public int findKthLargest2(int[] A, int k) {
        k = A.length - k; // convert to index of k largest
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int i = l; // partition [l,r] by A[l]: [l,i]<A[l], [i+1,j)>=A[l]
            for (int j = l + 1; j <= r; j++)
                if (A[j] < A[l]) swap(A, j, ++i);
            swap(A, l, i);

            if (k < i) r = i - 1;
            else if (k > i) l = i + 1;
            else return A[i];
        }
        return -1; // k is invalid
    }

    public static void main(String[] args) {
        int [] array = {3,1,2,4};
        int k =2;
        KthLargest kthLargest = new KthLargest();
        System.out.println(kthLargest.findKthLargest2(array,k));

    }
}
