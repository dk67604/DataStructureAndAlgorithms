package main.java.binarysearch;

public class FloorCeilNumber {

    public static   int getCeil(int[] A, int x){
        //search space is A[left..right]
        int left =0, right = A.length-1;
        //initialize ceil to -1
        int ceil = -1;
        while (left <= right){
            //find the mid value in the search space
            int mid = (left+right)/2;
            if(A[mid] == x){
                return A[mid];
            }
            // if x is less than the mid element, ceil exists in the
            // sub-array A[left..mid]. We update ceil to the mid element
            // and reduce our search space to left subarray A[left..mid-1]
            else if (x < A[mid] ){
                ceil = A[mid];
                right = mid -1;
            }
            // if x is more than the mid element, ceil exists in the
            // right sub-array A[mid+1..right]
            else {
                left = mid + 1;
            }
        }
        return ceil;
    }
    // Function to find floor of x in sorted array A[]
    // i.e. largest integer less than or equal to x
    public static int getFloor(int[] A, int x)
    {
        int left = 0, right = A.length - 1;

        // initialize floor to -1
        int floor = -1;

        // iterate till search space contains at-least one element
        while (left <= right)
        {
            // find the mid value in the search space
            int mid = (left + right) / 2;

            // if x is equal to mid element, it is the floor
            if (A[mid] == x) {
                return A[mid];
            }

            // if x is less than the mid element, floor exists in the left
            // sub-array A[left..mid-1]
            else if (x < A[mid]) {
                right = mid - 1;
            }

            // if x is more than the mid element, floor exists in the
            // sub-array A[mid..right]. We update floor to the mid element
            // and reduce our search space to right subarray A[mid+1..right]
            else {
                floor = A[mid];
                left = mid + 1;
            }
        }

        return floor;
    }

    public static void main(String[] args)
    {
        int[] A = { 1, 4, 6, 8, 9 };

        for (int i = 0; i <= 10; i++)
        {
            System.out.print("Number " + i + " -> ");
            System.out.println("ceiling is " + getCeil(A, i)
                    + ", floor is " + getFloor(A, i));
        }
    }
}
