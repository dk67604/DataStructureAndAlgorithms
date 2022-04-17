package main.java.lc_2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/buildings-with-an-ocean-view/
 * There are n buildings in a line. You are given an integer array heights of size n that represents the heights of the buildings in the line.
 *
 * The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without obstructions. Formally, a building has an ocean view if all the buildings to its right have a smaller height.
 *
 * Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.
 * Example 1:
 *
 * Input: heights = [4,2,3,1]
 * Output: [0,2,3]
 * Explanation: Building 1 (0-indexed) does not have an ocean view because building 2 is taller.
 * Example 2:
 *
 * Input: heights = [4,3,2,1]
 * Output: [0,1,2,3]
 * Explanation: All the buildings have an ocean view.
 * Example 3:
 *
 * Input: heights = [1,3,2,4]
 * Output: [3]
 * Explanation: Only building 3 has an ocean view.
 */
public class LC1762 {
    public int[] findBuildings(int[] heights) {
        //Use approach of monotonically decreasing stack
        int n = heights.length;
        List<Integer> list = new ArrayList<>();

        //Monotonically decreasing stack
        /**
         A stack when it consists of elements only in decreasing order is known as a monotonically decreasing stack.
         The basic idea is to only push the new element onto the stack if it is strictly smaller than the top element, otherwise pop all elements that are less than or equal to the new element from the top of the stack, and then push the new element onto the stack. This way, the stack's elements will be in strictly decreasing order.
         */
        Stack<Integer> stack = new Stack<>();
        for(int current = n-1; current >=0; --current){
            //if the building to the right is smaller, we can pop it.
            while(!stack.isEmpty() && heights[stack.peek()] < heights[current]){
                stack.pop();
            }
            //if the stack is empty, it means there is no building to the right
            // that can block the view of the current building
            if(stack.isEmpty()){
                list.add(current);
            }
            //Push the current building in the stack
            stack.push(current);
        }
        //Push the element in reverse order from array
        int[] answer = new int[list.size()];
        for(int i =0; i< list.size();i++){
            answer[i] = list.get(list.size()-1-i);
        }
        return answer;
    }
}
