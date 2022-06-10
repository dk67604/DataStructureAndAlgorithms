package main.java.topcodingquestion.stacks;

import java.util.Stack;

public class MaximumSubArrayMinProduct {
    long[] prefix;
    public int maxSumMinProduct(int[] nums){
        long res =0;
        Stack<Integer> stack = new Stack<>(); // monotone increasing stack
        prefix = new long[nums.length+1];
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];

        for (int i =0; i< n;++i){
            prefix[i+1] = prefix[i] + nums[i];
        }
        // Find all left index
        for(int i =0;i<n;i++){
            // Until stack is non-empty
            // & top element is greater
            // than the current element
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                l[i] = stack.peek() + 1;
            }
            else {
                l[i] = 0;
            }

            stack.push(i);
        }
        stack.clear();
        // Find all right index
        for(int i = n-1;i>=0;i--){
            // Until stack is non-empty
            // & top element is greater
            // than the current element
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                r[i] = stack.peek() - 1;
            }
            else {
                r[i] = n -1;
            }
            stack.push(i);
        }
        for(int i =0;i<n;i++){
            res = Math.max(res, getSum(l[i],r[i]) * nums[i]);
        }

        return (int)(res % 1000_000_007)  ;
    }
    long getSum(int left, int right) { // left, right inclusive
        return prefix[right + 1] - prefix[left];
    }

    public static void main(String[] args) {
        MaximumSubArrayMinProduct maximumSubArrayMinProduct = new MaximumSubArrayMinProduct();
        System.out.println(maximumSubArrayMinProduct.maxSumMinProduct(new int[]{1,2,3,2}));
    }
}
