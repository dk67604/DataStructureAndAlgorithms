package main.java.leetcode;

import java.util.Stack;

public class LargestRecInHist {

    public int largestRectangleArea(int[] heights) {
        // Create an empty stack to store the index of heights
        //The indexes stored in this array is always in increasing order
        Stack<Integer> stack=new Stack<>();
        int top_index; // Store the index of top of stack
        int area_with_top_index; // Area with  top of stack
        int max_area=Integer.MIN_VALUE; // Store the max area
        int i=0;
        int len=heights.length;
        while(i<len){
            // If this bar is higher than the bar on top stack, push it to stack
            if(stack.isEmpty()||heights[stack.peek()]<=heights[i]){
                stack.push(i++);
            }
            // If this bar is lower than top of stack, then calculate area of rectangle
            // with stack top as the smallest (or minimum height) bar. 'i' is
            // 'right index' for the top and element before top in stack is 'left index'
            else{
                top_index=stack.peek();
                stack.pop();
                // Calculate the area with heights[top_index] stack as smallest bar
                area_with_top_index=heights[top_index]*(stack.isEmpty()?i:i-stack.peek()-1);
                max_area=Math.max(max_area,area_with_top_index);
            }
        }


        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (!stack.isEmpty()){
            top_index=stack.peek();
            stack.pop();
            area_with_top_index=heights[top_index]*(stack.isEmpty()?i:i-stack.peek()-1);
            max_area=Math.max(max_area,area_with_top_index);
        }
        return max_area;
    }

    public static void main(String[] args) {
        int[] heights={2,1,5,6,2,3};
        LargestRecInHist largestRecInHist=new LargestRecInHist();
        System.out.println(largestRecInHist.largestRectangleArea(heights));
    }
}
