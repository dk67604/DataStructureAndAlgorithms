package main.java.topcodingquestion.stacks;

import java.util.Stack;

public class MaxChunToSorted {
    public int maxChunksToSortedII(int[] arr) {
        Stack<Integer> stack = new Stack<>(); // Monotonic increasing stack
        int largest = 0;
        for(int num: arr){
            largest = num;
            while(!stack.isEmpty() && stack.peek() > num){
                largest = Math.max(stack.pop(),largest);
            }
            stack.push(largest);
        }
        return stack.size();

    }
    public int maxChunksToSortedI(int[] arr) {
        int max = 0, count =0;
        for(int i = 0; i< arr.length; i++){
            max = Math.max(max, arr[i]);
            if(max == i){
                count++;
            }
        }
        return count;
    }
}
