package main.java.leetcode;

public class MaxStack {
	private Node stack;
	private Node max;
	
	public void push(int x) {
		Node n=new Node();
		n.val=x;
		if(stack==null) {
			stack=n;
		}else {
			n.next=stack;
			stack=n;
		}
		if(max==null||n.val>max.val) {
			n.oldMax=max;
			max=n;
		}
	}
	
	private int pop() {
		if(stack==null) throw new NullPointerException();
		Node n=stack;
		stack=n.next;
		max=n.oldMax;
		return n.val;
		
	}
	public int max() {
		if(max==null) throw new NullPointerException();
		return max.val;
	}
	
	public static void main(String[] args) {
		MaxStack maxStack=new MaxStack();
		maxStack.push(1);
		maxStack.push(3);
		System.out.println(maxStack.max());
		maxStack.push(2);
		maxStack.push(1);
		maxStack.pop();
		maxStack.pop();
		maxStack.pop();
		System.out.println(maxStack.max());
	}
}
