package main.java.leetcode;

/*
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.

ConstructLinkedList:
Idea is to push the index of '(' in the stack, pop when encounter ")"
For extra ")" set the index with '*' and before returning final result replace
"*" with empty character
in the end make sure to check for unpaired "(" and replace with *;
 */


import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();
        for (int i  =0;i<sb.length();i++){
            if(sb.charAt(i) == '('){
                st.push(i);
            }
            else if(sb.charAt(i) == ')'){
                if(!st.isEmpty()) st.pop();
                else sb.setCharAt(i,'*');
            }
        }
        while (!st.isEmpty()){
            sb.setCharAt(st.pop(),'*');
        }
        return sb.toString().replace("*","");

    }

    public static void main(String[] args) {
        MinimumRemovetoMakeValidParentheses minimumRemovetoMakeValidParentheses =
                new MinimumRemovetoMakeValidParentheses();
        String test1 = "lee(t(c)o)de)";
        System.out.println(minimumRemovetoMakeValidParentheses.minRemoveToMakeValid(test1));
    }

}
