package main.java.topcodingquestion.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BuildingWithAnOceanView {
    public int[] findBuildings(int[] heights) {
        //Use approach of monotonicaly decreasing stack
        int n = heights.length;
        List<Integer> list = new ArrayList<>();

        //Monotonically decreasing stack
        /**
         A stack when it consists of elements only in decreasing order is known as a monotonically decreasing stack.
         The basic idea is to only push the new element onto the stack if it is strictly smaller than the top element,
         otherwise pop all elements that are less than or equal to the new element from the top of the stack, and then
         push the new element onto the stack. This way, the stack's elements will be in strictly decreasing order.
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
