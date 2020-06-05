package main.java.binarysearch;

public class NumberOfOnes {
    // Function to find number of 1's in a sorted binary array
    public static int count(int[] A, int left, int right){
        //if the last element is 0 than return 0
        if(A[right] == 0) return  0;
        //if the first element is 1, all elements are ones as the array is sorted
        if(A[left] == 1) return right-left+1;

        int mid = (left + right)/2;
        //Divide the array into left and right sub-array and recur
        return count(A,left,mid) + count(A,mid+1,right);
    }

    public static void main(String[] args)
    {
        int[] A = { 0, 0, 0, 0, 1, 1, 1 };

        System.out.println("Total number of 1's present are "
                + count(A, 0, A.length - 1));
    }
}
