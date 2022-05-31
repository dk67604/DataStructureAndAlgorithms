package main.java.topcodingquestion.arraysandstrings;

import java.util.Arrays;

public class ProductArrayExceptItself {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        output[0] = 1;
        int len = nums.length;
        //Left
        for (int i = 1; i < len; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            output[i] = output[i] * right;
            right = right * nums[i];
        }
        return output;
    }

    public static void main(String[] args) {
        ProductArrayExceptItself productArrayExceptItself = new ProductArrayExceptItself();
        int[] nums = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(productArrayExceptItself.productExceptSelf(nums)));
    }
}
