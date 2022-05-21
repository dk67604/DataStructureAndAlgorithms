package main.java.topcodingquestion.stacks;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        // Create an empty stack to store the index of heights
        //The indexes stored in this array is always in increasing order
        Stack<Integer> stack = new Stack<>();
        int topIndex = 0;
        int maxArea = Integer.MIN_VALUE;
        int areaWithTopIndex  = 0;
        int index = 0, length = heights.length;
        while (index < length){
            // If this bar is higher than the bar on top stack, push it to stack
            if( stack.isEmpty() || heights[stack.peek()] <= heights[index]){
                stack.push(index++);
            }
            // If this bar is lower than top of stack, then calculate area of rectangle
            // with stack top as the smallest (or minimum height) bar. 'i' is
            // 'right index' for the top and element before top in stack is 'left index'
            else {
                topIndex = stack.peek();
                stack.pop();
                // Calculate the area with heights[top_index] stack as smallest bar
                areaWithTopIndex = heights[topIndex] * (stack.isEmpty()?index:index-stack.peek()-1);
                maxArea = Math.max(areaWithTopIndex,maxArea);
            }
        }
        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (!stack.isEmpty()){
            topIndex = stack.peek();
            stack.pop();
            // Calculate the area with heights[top_index] stack as smallest bar
            areaWithTopIndex = heights[topIndex] * (stack.isEmpty()?index:index-stack.peek()-1);
            maxArea = Math.max(areaWithTopIndex,maxArea);
        }
        return maxArea == Integer.MIN_VALUE?0:maxArea;
    }
}
