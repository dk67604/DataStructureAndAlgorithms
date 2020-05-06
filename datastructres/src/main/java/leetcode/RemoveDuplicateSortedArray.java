package main.java.leetcode;

public class RemoveDuplicateSortedArray {

    // Use two pointer method, the one will be slower and the other will be faster.
    // Whenever duplicate element found increase the faster pointer and when duplicate doesn't
    // occur than increase slow pointer and copy the value from faster pointer location to slower
    //  pointer location
    public int removeDuplicates(int[] A) {
        int count=0;
        int n=A.length;
        for(int i=1;i<n;i++){
            if(A[i]==A[i-1])count++;
            else{
                A[i-count]=A[i];
            }
        }
        return n-count;
    }
}
