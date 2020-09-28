package main.java.educative.io.coding.twopointers;

public class ShortestWindowSort {
    public static int sort(int[] arr) {
        int low =0, high = arr.length - 1;
        //find the first number out of sorting order from the beginning
        while (low < arr.length - 1 && arr[low] <= arr[low+1])
            low++;
        // if the array is sorted
        if(low == arr.length -1)
            return 0;
        //find the first number out of sorting order from the end
        while (high>0 && arr[high] >= arr[high-1])
            high--;

        //find the minimum and maximum of the sub-array
        int subArrayMax = Integer.MIN_VALUE, subArrayMin = Integer.MAX_VALUE;
        for(int k = low; k<=high; k++){
            subArrayMax = Math.max(subArrayMax,arr[k]);
            subArrayMin = Math.min(subArrayMin,arr[k]);
        }
        // extend the subarray to include any number which is bigger than the minimum of the subarray
        while (low > 0 && arr[low-1] > subArrayMin)
            low --;
        while (high < arr.length -1 &&  arr[high+1] < subArrayMax)
            high++;

        return high - low +1;
    }
    public static void main(String[] args) {
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 3 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 3, 2, 1 }));
    }
}
