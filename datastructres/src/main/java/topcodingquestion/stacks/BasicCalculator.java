package main.java.topcodingquestion.stacks;

import java.util.Stack;

//https://leetcode.com/problems/basic-calculator/solution/
//https://leetcode.com/problems/basic-calculator/discuss/62361/Iterative-Java-solution-with-stack
public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        int sign = 1;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = 10 * number + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                sign = 1;
                number = 0;
            } else if (c == '-') {
                result += sign * number;
                sign = -1;
                number = 0;
            } else if (c == '(') {
                //we push the result first,then sign
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for parentheses
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();//sign before parentheses
                result += stack.pop(); //now is the result before the parentheses

            }
        }
        if (number != 0) result += sign * number;
        return result;
    }
}
