package main.java.leetcode;

import java.util.Stack;

public class StackExp {

	static void superStack(String[] operations) {
		Stack<String> stack=new Stack<>();
		for(String inp:operations) {
			String[] seq=inp.split(" ");
			switch (seq[0]) {
			case "push":
				System.out.println(seq[1]);
				stack.push(seq[1]);
				break;
			case "pop":
				if(!stack.isEmpty()) {
					String val=stack.pop();
					System.out.println(val);
					break;
				}
				
				if(stack.isEmpty()) {
					System.out.println("EMPTY");
				}else{
					System.out.println();
				}
				break;
			case "inc":
				stack=incOp(stack, Integer.valueOf(seq[1]), Integer.valueOf(seq[2]));
				System.out.println(stack.peek());
				break;
			default:
				break;
			}
		}
		
		
    }
	
	
	static Stack<String> incOp(Stack<String> stack,int e, int k) {
		Stack<String> temp=new Stack<>();
		int i=0;
		while(!stack.isEmpty()) {
			temp.push(stack.pop());
		}
		while(i<e) {
			stack.push(String.valueOf(Integer.parseInt(temp.pop())+k));
			i++;
		}
		while(!temp.isEmpty()) {
			stack.push(temp.pop());
		}
		
		return stack;
	}
}
