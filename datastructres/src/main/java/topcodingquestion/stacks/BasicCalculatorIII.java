package main.java.topcodingquestion.stacks;

import java.util.Stack;
class Pair{
    Stack<Integer> st;
    char sign;
    Pair( Stack<Integer> s, char si){
        this.st = s;
        this.sign = si;
    }
}

public class BasicCalculatorIII {

    private void cal(Stack<Integer> stack, int currentNumber, char operation){
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
    }

    public int calculate(String s){
        Stack<Integer> st = new Stack<>();
        Stack<Pair> stP = new Stack<>();
        int n = s.length();
        char sign = '+';
        for (int i =0; i< n; i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int val =0;
                while (i < n && Character.isDigit(s.charAt(i))){
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                cal(st,val,sign);
            }
            else if (ch == '('){
                stP.push(new Pair(st,sign));
                sign = '+';
                st = new Stack<>();
            }
            else if(ch == ')'){
                int val = 0;
                while (!st.isEmpty()){
                    val += st.pop();
                }
                Pair p = stP.pop();
                st = p.st;
                sign = p.sign;
                cal(st,val,sign);
            }
            else if(ch != ' '){
                sign = ch;
            }
        }
        int sum =0;
        while (!st.isEmpty()) sum += st.pop();
        return sum;
    }

    public static void main(String[] args) {
        BasicCalculatorIII basicCalculatorIII = new BasicCalculatorIII();
        System.out.println(basicCalculatorIII.calculate("1+1"));
    }
}
