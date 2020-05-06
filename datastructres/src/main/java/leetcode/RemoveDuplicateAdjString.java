package main.java.leetcode;

import java.util.Stack;

public class RemoveDuplicateAdjString {
    public String removeDuplicates(String S) {
        StringBuffer sb=new StringBuffer();

        Stack<Character> stack=new Stack<>();
        for(char c:S.toCharArray()){
            if(!stack.isEmpty() && c==stack.peek()){
                stack.pop();
            }
            else{

                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
    public String removeDuplicates2(String S) {
        char[] stack=new char[S.length()];
        int i=0;
        int len=S.length();
        for(int j=0;j<len;j++){
            if(i>0 && stack[i-1]==S.charAt(j)){
                --i;
            }
            else{
                stack[i++]=S.charAt(j);
            }
        }
        return new String(stack,0,i);
    }

    public static void main(String[] args) {
        RemoveDuplicateAdjString removeDuplicateAdjString=new RemoveDuplicateAdjString();
        System.out.println(removeDuplicateAdjString.removeDuplicates2("abbaca"));
    }
}
