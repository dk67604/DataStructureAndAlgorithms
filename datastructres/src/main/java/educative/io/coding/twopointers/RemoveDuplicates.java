package main.java.educative.io.coding.twopointers;

/**
 * Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing the duplicates in-place return the new length of the array.
 *
 * Example 1:
 *
 * Input: [2, 3, 3, 3, 6, 9, 9]
 * Output: 4
 * Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
 * Example 2:
 *
 * Input: [2, 2, 2, 11]
 * Output: 2
 * Explanation: The first two elements after removing the duplicates will be [2, 11].
 */
public class RemoveDuplicates {
    public static int remove(int[] arr) {
        int nextNonDuplicate = 1;//index of the next non-duplicate element
        for(int i = 1;i< arr.length;i++){
            if(arr[nextNonDuplicate-1]!= arr[i]){
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }
        return nextNonDuplicate;
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(RemoveDuplicates.remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(RemoveDuplicates.remove(arr));
    }
}
