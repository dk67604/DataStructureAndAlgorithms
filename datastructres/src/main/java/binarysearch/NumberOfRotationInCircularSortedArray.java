package main.java.binarysearch;

public class NumberOfRotationInCircularSortedArray {

    public  int findRotationCount(int[] A){
        int n = A.length;
        int left =0;
        int right = n-1;
        while (left<=right){
            //Case 1: if the search space is already sorted
            // than we have found the minimum index(i.e. left)
            if(A[left]<=A[right]) return left;
            int mid = (left+right)/2;
            //Find the next and prev element of the mid
            // in circular manner
            int prev = (mid-1 +n)%n;
            int next = (mid+1)%n;
            //Case 2: if the mid element is less than both the prev and next
            // than it is the minimum index of the array
            // (special property of the pivot in circular sorted array)
            if(A[mid]<=A[prev] && A[mid]<=A[next] ){
                return mid;
            }

            // if A[mid..right] is sorted and mid is not the min element,
            // then pivot element cannot be present in A[mid..right] and
            // we can discard A[mid..right] and search in the left half

            else if (A[mid] <= A[right]) {
                right = mid - 1;
            }

            // if A[left..mid] is sorted then pivot element cannot be
            // present in it and we can discard A[left..mid] and search
            // in the right half

            else if (A[mid] >= A[left]) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        NumberOfRotationInCircularSortedArray numberOfRotationInCircularSortedArray=
                new NumberOfRotationInCircularSortedArray();
        System.out.println(numberOfRotationInCircularSortedArray.findRotationCount(new int[]{8, 9, 10, 1, 2, 3, 4, 5, 6, 7}));
        System.out.println(numberOfRotationInCircularSortedArray.findRotationCount(new int[]{1,2,3,4,5,6,7}));

    }
}
