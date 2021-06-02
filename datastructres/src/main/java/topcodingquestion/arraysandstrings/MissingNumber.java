package main.java.topcodingquestion.arraysandstrings;

public class MissingNumber {
    //ConstructLinkedList when array not starts from 0
    public int missingNumber2(int[] nums) {
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
}
