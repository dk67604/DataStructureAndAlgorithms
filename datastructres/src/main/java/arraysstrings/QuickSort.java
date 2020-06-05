package main.java.arraysstrings;

import java.util.Arrays;

public class QuickSort {

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

    public void sort(int[] array,int low, int high){
        if(low < high){
            int pi = partition(array,low,high);
            sort(array,low,pi-1);
            sort(array,pi+1,high);
        }
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int [] array = {1,10,7,8,9,1,5};
        quickSort.sort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

}
