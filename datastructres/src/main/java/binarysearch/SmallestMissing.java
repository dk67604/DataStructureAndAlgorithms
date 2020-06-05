package main.java.binarysearch;

public class SmallestMissing {

    // Function to find smallest missing element in a sorted
    // array of distinct non-negative integers
    public  int smallestMissing(int[] A, int left, int right){
        //Base condition
        if(left > right){
            return left;
        }
        int mid = left + (right - left)/2;
        // if mid index matches with its value, than the mismatch
        // lies on the right half
        if(A[mid] == mid)
            return smallestMissing(A,mid+1,right);
        else
            //mismatch lies on the left half
            return smallestMissing(A,left,mid-1);
    }
    public static void main(String[] args)
    {
        int[] A = { 0, 1, 2, 3, 4, 5, 6 };
        SmallestMissing smallestMissing = new SmallestMissing();
        int left = 0, right = A.length - 1;
        System.out.println("The smallest missing element is "
                + smallestMissing.smallestMissing(A, left, right));
    }
}
