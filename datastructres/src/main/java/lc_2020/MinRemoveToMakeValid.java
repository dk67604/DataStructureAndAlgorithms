package main.java.lc_2020;

import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * Given a string s of '(' , ')' and lowercase English characters.

 Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

 Formally, a parentheses string is valid if and only if:

 It is the empty string, contains only lowercase characters, or
 It can be written as AB (A concatenated with B), where A and B are valid strings, or
 It can be written as (A), where A is a valid string.
 */
public class MinRemoveToMakeValid {
    public String minRemoveToMakeValid(String s){
        Stack<Integer> indexStack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for (int index =0; index < s.length(); index++){
            if(sb.charAt(index) == '('){
                indexStack.push(index);
            }
            else if(sb.charAt(index) == ')'){
                if(!indexStack.isEmpty()) indexStack.pop();
                else
                    sb.setCharAt(index, '*');
            }
        }
        while (!indexStack.isEmpty()){
            sb.setCharAt(indexStack.pop(), '*');
        }
        return sb.toString().replace("*", "");
    }

    public static void main(String[] args) {
        String test1 = "lee(t(c)o)de)";
        MinRemoveToMakeValid minRemoveToMakeValid = new MinRemoveToMakeValid();
        System.out.println(minRemoveToMakeValid.minRemoveToMakeValid(test1));
    }
}
