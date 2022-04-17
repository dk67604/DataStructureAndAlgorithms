package main.java.lc_2020;

import java.util.Stack;

/** https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 * A parentheses string is valid if and only if:
 *
 * It is the empty string,
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
 *
 * For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
 * Return the minimum number of moves required to make s valid.
 */
public class LC921 {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int ans = 0; // minimum add required to make valid
        for(int i =0; i< s.length();i++){
            char temp = s.charAt(i);
            if(temp == '('){
                stack.push(temp);
            }
            else if(!stack.isEmpty()){
                stack.pop();
            }
            else{
                ans++;
            }
        }
        while(!stack.isEmpty()){
            ans++;
            stack.pop();
        }
        return ans;
    }
}
