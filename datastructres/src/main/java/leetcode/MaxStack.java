package main.java.leetcode;
//TODO
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
		if (stack == null) throw new NullPointerException();
		Node n = stack;
		stack = n.next;
		max = n.oldMax;
		return n.val;

	}

	public static void main(String[] args) {
		MaxStack maxStack = new MaxStack();
		maxStack.push(5);
		maxStack.push(1);
		maxStack.push(5);
		System.out.println(maxStack.top());
		System.out.println(maxStack.popMax());
		System.out.println(maxStack.top());
		System.out.println(maxStack.peekMax());
		System.out.println(maxStack.pop());
		System.out.println(maxStack.top());


	}

	public int top() {
		if (stack == null) throw new NullPointerException();
		return stack.val;
	}

	public int popMax() {
		if (max == null) throw new NullPointerException();
		Node n = max;
		if (stack.val == n.val) {
			stack = stack.next;
			stack.oldMax = n;
		}
		max = n.next;

		return n.val;
	}

	public int peekMax() {
		if (max == null) return stack.oldMax.val;
		return max.val;
	}
}
