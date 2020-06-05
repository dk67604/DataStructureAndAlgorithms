package main.java.binarysearch;

public class FirstOrLastOccurenceInSortedArray {
    public  int findFirstOccurrence(int[] A, int x){
        int left =0;
        int right = A.length;
        int result = -1;
        while (left<=right){
            int mid = (left + right)/2;
            if(x == A[mid]){
                result = mid;
                right = mid -1;
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
        int key = 9;
        FirstOrLastOccurenceInSortedArray firstOrLastOccurenceInSortedArray =
                new FirstOrLastOccurenceInSortedArray();
        int index = firstOrLastOccurenceInSortedArray.findFirstOccurrence(A, key);

        if (index != -1) {
            System.out.println("First occurrence of element " + key +
                    " is found at index " + index);
        } else {
            System.out.println("Element not found in the array");
        }
    }
}
