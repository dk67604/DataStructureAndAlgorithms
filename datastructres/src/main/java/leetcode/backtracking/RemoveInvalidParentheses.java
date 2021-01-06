package main.java.leetcode.backtracking;

import java.util.*;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        int minimumRemovalAllowed = getMin(s);
        helper(result,new HashSet<String>(),s,minimumRemovalAllowed);
        return result;

    }

    private void helper(List<String> result, HashSet<String> set, String s,int minimumRemovalAllowed){
        if(minimumRemovalAllowed == 0){
            int minimumRemovalAllowedNow = getMin(s);
            if(minimumRemovalAllowedNow == 0){
                if(!set.contains(s)){
                    result.add(s);
                    set.add(s);
                }
            }
        }
        for(int i = 0; i< s.length();i++){
            String left = s.substring(0,i);
            String right = s.substring(i+1);
            helper(result,set,left + right,minimumRemovalAllowed-1);
        }
    }



    private int getMin(String str){
        Stack<Character> stack = new Stack<>();
        for(int i =0; i < str.length();i++){
            char ch = str.charAt(i);
            if( ch == '('){
                stack.push(ch);
            }else if(ch == ')') {
               if(stack.size() == 0 || stack.peek() == ')'){
                   stack.push(ch);
               }
               else if(stack.peek() == '('){
                   stack.pop();
               }
            }
        }
        return stack.size();
    }
    public  List<String> removeInvalidParentheses2(String s) {
        List<String> result = new ArrayList<>();
        char[] par = new char[]{'(', ')'};
        dfs(s,result,par,0,0);
        return result;
    }

    private void dfs(String s, List<String> result,char[] par,int last_i,int last_j){
        int i = last_i;

        int count = 0;
        while(i < s.length() && count >=0){
            if(s.charAt(i) == par[0]) count++;
            if(s.charAt(i) == par[1]) count--;
            i++;
        }

        if(count >= 0){
            // no extra ')' is detected. There is extra '(' have to detect so reverse the string
            String reversed = new StringBuilder(s).reverse().toString();
            if(par[0] == '(') dfs(reversed,result,new char[]{')','('},0,0);
            else result.add(reversed);
        }
        else{
            // extra ')' detected and we have to do something
            i-=1;
            for(int j = last_j;j<=i;j++){
                if(s.charAt(j) == par[1] &&(j == last_j || s.charAt(j-1) != par[1])){
                    dfs(s.substring(0,j) + s.substring(j+1,s.length()),result, par,i,j);
                }
            }
        }
    }


    public static void main(String[] args) {
        RemoveInvalidParentheses removeInvalidParentheses = new RemoveInvalidParentheses();

        String s = "()())()";
        System.out.println(Arrays.toString(removeInvalidParentheses.removeInvalidParentheses2(s).toArray()));
    }
}
