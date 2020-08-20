package main.java.arraysstrings;

public class MissingNumber {
    //ConstructLinkedList when array not starts from 0
    public int missingNumber2(int[] nums){
        int i, total;
        int n = nums.length;
        total = (n + 1) * (n + 2) / 2;
        for (i = 0; i < n; i++)
            total -= nums[i];
        return total;
    }
    //ConstructLinkedList when array starts from 0
    public int missingNumber(int[] nums) {

        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }

    public static void main(String[] args) {
        int[] nums = {0,1, 2, 3, 4,5};
        int[] nums2 = {0,1, 2, 3, 4, 5, 6, 8, 9, 10};
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(nums));
        System.out.println(missingNumber.missingNumber(nums2));
    }
}
