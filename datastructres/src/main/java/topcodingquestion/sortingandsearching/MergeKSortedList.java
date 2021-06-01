package main.java.topcodingquestion.sortingandsearching;

import java.util.PriorityQueue;

public class MergeKSortedList {
    public static ListNode merge(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((n1, n2) -> n1.value - n2.value);
        //put the root pof each list in the min Heap
        for (ListNode listNode : lists) {
            if (listNode != null)
                minHeap.add(listNode);
        }
        // take the smallest (top) element form the min-heap and add it to the result;
        // if the top element has a next element add it to the heap
        ListNode resultHead = null, resultTail = null;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            if (resultHead == null) {
                resultHead = resultTail = node;
            } else {
                resultTail.next = node;
                resultTail = resultTail.next;
            }
            if (node.next != null) {
                minHeap.add(node.next);
            }
        }
        return resultHead;
    }
}
