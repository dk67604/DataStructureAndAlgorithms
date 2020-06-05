package main.java.binarysearch;

public class SerachElementinCircularSortedArray {
    public  int circularArraySearch(int[] A, int x){
        int left = 0;
        int right = A.length -1;
        //iterate till search space contains at least one element
        while (left<=right){
            //find the mid value in the search space
            // compare it with the search element
            int mid  = (left+right)/2;
            if(A[mid] == x) return mid;

            //if right half(A[mid]...A[right]) is sorted
            // and mid is not the key element
            if(A[mid] <= A[right]){
                // compare key with A[mid] and A[right] to know
                // if it lies in A[mid..right] or not
                if(x>A[mid] && x<=A[right]){
                    // go searching in right sorted half
                    left =mid+1;
                }else {
                    right = mid -1;
                }
            }
            //if left half(A[left]...A[mid]) is sorted
            // and mid is not the key element
            else {
                // compare key with A[left] and A[mid] to know
                // if it lies in A[left..mid] or not
                if(x>=A[left] && x<A[mid]){
                        // go searching in left sorted half
                        right = mid -1;
                }
                else {
                    left = mid +1;
                }
            }

        }
        //key not found or invalid input
        return -1;
    }

    public static void main(String[] args) {
        SerachElementinCircularSortedArray serachElementinCircularSortedArray
                = new SerachElementinCircularSortedArray();
        System.out.println(serachElementinCircularSortedArray.circularArraySearch(
                new int[]{9, 10, 2, 5, 6, 8},5
        ));
    }
}
