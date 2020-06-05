package main.java.arraysstrings;

public class BinarySearch {

    public boolean binarySearch(int[] arr,int key){
        return helper(arr,0,arr.length-1,key);

    }

    public boolean helper(int[] arr, int lo, int hi, int key){

        if (hi >= lo) {
            int mid = lo + (hi - lo) / 2;
            // if the element is present at the middle itself
            if (key == arr[mid]) return true;

            //If the element is smaller than middle, then it can only
            // be present in left subarray
            if (arr[mid] > key) {
                return helper(arr, lo, mid - 1, key);
            } else {
                //Else the element can only be present at right subarray
                return helper(arr, mid + 1, hi, key);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,10,40};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch(arr,-1));
    }
}
