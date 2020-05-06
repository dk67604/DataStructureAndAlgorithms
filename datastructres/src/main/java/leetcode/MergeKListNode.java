package main.java.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKListNode {
	/*
	 * Merge k sorted linked lists and return it as one sorted list. 
	 * Analyze and describe its complexity.
	 */
	 public ListNode mergeKLists(ListNode[] lists) {
		 PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
	            @Override
	            public int compare(ListNode o1,ListNode o2){
	                if (o1.val<o2.val)
	                    return -1;
	                else if (o1.val==o2.val)
	                    return 0;
	                else 
	                    return 1;
	            }
	        });
	        ListNode head=new ListNode(0);
	        ListNode dummy=head;
	        for(ListNode node:lists) 
	        	if(node!=null)queue.add(node);
	        
	        
	        while(!queue.isEmpty()) {
	        	dummy.next=queue.poll();
	        	dummy=dummy.next;// assign the next node to dummy since insertion happens
	        	// from the end
	        	if(dummy.next!=null) {
	        		queue.add(dummy.next);
	        	}
	        }
	        return head.next;
	    }
}
