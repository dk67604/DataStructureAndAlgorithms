package main.java.binarysearch;
/*
Count occurrences of a number in a sorted array with duplicates
 */

public class CountOccurrences {
    public  int binarySearch(int[] A, int x, boolean searchFirst){
        //search space is A[left..right]
        int left =0;
        int right = A.length;
        int result = -1;
        while (left<=right){
            int mid = (left + right)/2;
            if(x == A[mid]){
                result = mid;
                if(searchFirst){
                    right = mid -1;
                }

                else {
                    left = mid +1;
                }
            }
            else if(x<A[mid]){
                right = mid -1;
            }
            else {
                left = mid +1;
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        int[] A = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
        int key = 5;
        CountOccurrences countOccurrences = new CountOccurrences();

        // pass true for first occurrence
        int first = countOccurrences.binarySearch(A, key, true);

        // pass false for last occurrence
        int last = countOccurrences.binarySearch(A, key, false);

        int c = last - first + 1;

        if (first != -1) {
            System.out.println("Element " + key + " occurs " + c + " times");
        } else {
            System.out.println("Element not found in the array");
        }
    }
}
