package main.java.topcodingquestion.stacks;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String str) {
        if (str == null || str.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int left = -1;
        int max = 0;
        stack.push(left);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
