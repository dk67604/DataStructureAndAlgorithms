package main.java.topcodingquestion.stacks;

import java.util.*;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> ans = new HashSet<>();
        List<String> result = new ArrayList<>();
        int mra = getMin(s);
        solution(s,mra,ans,result);
        return result;
    }

    private void solution(String str, int mra, Set<String> ans, List<String> result){
        if(mra == 0){
            int mrnow = getMin(str);
            if (mrnow == 0){
                if(!ans.contains(str)){
                    result.add(str);
                    ans.add(str);
                }
            }
            return;
        }
        for (int i = 0;i< str.length();i++){
            String left = str.substring(0,i);
            String right = str.substring(i+1);
            solution(left + right,mra-1,ans,result);
        }
    }

    private int getMin(String str){
        Stack<Character> stack = new Stack<>();
        for(char ch: str.toCharArray()){
            if(ch == '('){
                stack.push(ch);
            }else if(ch == ')'){
                if (stack.isEmpty()){
                    stack.push(ch);
                }else if(stack.peek() == ')'){
                    stack.push(ch);
                }else if(stack.peek() == '('){
                    stack.pop();
                }
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses removeInvalidParentheses = new RemoveInvalidParentheses();
        List<String> res = removeInvalidParentheses.removeInvalidParentheses("(a)())()");
        for (String r: res){
            System.out.println(r);
        }
    }
}
