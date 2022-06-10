package main.java.topcodingquestion.stacks;

import java.util.Stack;

/**
 * Given a string s which represents an expression, evaluate this expression and return its value.
 *
 * The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: s = " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: s = " 3+5 / 2 "
 * Output: 5
 */
public class BasicCalculatorII {
    public int calculate(String s){
        if(s == null || s.isEmpty()) return 0;
        int result  =0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';
        for(int i = 0; i<len; i++){
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)){
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if(!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar)
            || i == len -1) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                }
                else if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
            while (!stack.isEmpty()){
                result += stack.pop();
            }

        return result;
    }

    public static void main(String[] args) {
        BasicCalculatorII basicCalculatorII = new BasicCalculatorII();
        System.out.println(basicCalculatorII.calculate(" 3+5 / 2 "));
    }
}
