package main.java.dsa_2024.algorithms;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> indexStack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for(int index = 0; index < s.length(); index++){
            if(sb.charAt(index) == '('){
                indexStack.push(index);
            }
            else if (sb.charAt(index) == ')'){
                if (!indexStack.isEmpty()) indexStack.pop();
                else
                    sb.setCharAt(index, '*');
            }
        }
        while(!indexStack.isEmpty()){
            sb.setCharAt(indexStack.pop(), '*');
        }
        return sb.toString().replace("*", "");
    }

}
