package main.java.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null|| lists.length ==0) return null;
        //Min Heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val < o2.val){
                    return -1;
                }
                else if(o1.val == o2.val)
                    return 0;
                else
                    return 1;
            }
        });
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        for (ListNode node:lists){
            if(node!=null)
                pq.add(node);
        }

        while (!pq.isEmpty()){
            dummy.next = pq.poll();
            // assign the next node to dummy since insertion happens
            // from the end
            dummy = dummy.next;
            if(dummy.next!=null){
                pq.add(dummy.next);
            }
        }
        return head.next;
    }
}
