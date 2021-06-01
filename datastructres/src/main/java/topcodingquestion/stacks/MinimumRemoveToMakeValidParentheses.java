package main.java.topcodingquestion.stacks;


import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        MinimumRemoveToMakeValidParentheses minimumRemovetoMakeValidParentheses =
                new MinimumRemoveToMakeValidParentheses();
        String test1 = "lee(t(c)o)de)";
        System.out.println(minimumRemovetoMakeValidParentheses.minRemoveToMakeValid(test1));
    }

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>(); // store the indexes of open parentheses
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (sb.charAt(i) == '(') {
                stack.push(i);
            } else if (sb.charAt(i) == ')') {
                if (!stack.isEmpty()) stack.pop();
                else
                    sb.setCharAt(i, '*');
            }
        }
        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '*');
        }
        return sb.toString().replace("*", "");
    }
}
