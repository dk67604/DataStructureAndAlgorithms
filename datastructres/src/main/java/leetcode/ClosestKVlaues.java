package main.java.leetcode;

import java.util.*;

public class ClosestKVlaues {
	 public List<Integer> closestKValues(TreeNode root, double target, int k) {
	        Deque<Integer> deque=new LinkedList<>();
	        inorder(root,deque);
	        while(deque.size()>k){
	            if(Math.abs(deque.peekFirst() - target)> Math.abs(deque.peekLast() - target)){
	                deque.pollFirst();
	            }else{
	                deque.pollLast();
	            }
	            
	        }
	        return new ArrayList<Integer>(deque);
	    }
	    
	    public void inorder(TreeNode node,Deque<Integer> deque){
	        if(node==null)return;
	        inorder(node.left,deque);
	        deque.add(node.val);
	        inorder(node.right,deque);
	    }
}
