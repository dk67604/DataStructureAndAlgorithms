package main.java.leetcode;

import java.util.Stack;

public class MinimumCostTreeFromLeaf {

    public int mctFromLeafValues(int[] arr) {
        if(arr == null || arr.length < 2){
            return 0;
        }

        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(int num : arr){

            // while num is bigger than peek(), pop and calculate
            while(!stack.isEmpty() && stack.peek() <= num){
                int mid = stack.pop();
                if(stack.isEmpty())
                    res += mid * num;
                else
                    res += mid * Math.min(stack.peek(), num);
            }

            stack.push(num); // if num is smaller, push into stack
        }

        // if there are values left in the stack, they sure will be mutiplied anyway
        // and added to the result.
        while(stack.size() > 1){ // > 1 because we have a peek() after pop() below
            res += stack.pop() * stack.peek();
        }

        return res;
    }

    public static void main(String[] args) {
        MinimumCostTreeFromLeaf minimumCostTreeFromLeaf = new MinimumCostTreeFromLeaf();
        int[] arr = {4,3,2,1,5};
        minimumCostTreeFromLeaf.mctFromLeafValues(arr);
    }
}
