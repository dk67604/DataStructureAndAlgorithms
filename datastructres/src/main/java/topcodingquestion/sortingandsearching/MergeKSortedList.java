package main.java.topcodingquestion.sortingandsearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6};
        int[] B = {2, 5, 7, 8};
        int[] C = {3, 9, 10, 12};
        int[] D = {0, 1, 2, 8};
        List<int[]> arrays = new ArrayList<>();
        arrays.add(A);
        arrays.add(B);
        arrays.add(C);
        arrays.add(D);
        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        System.out.println(mergeKSortedList.mergeArray(arrays));
        A = new int[]{1, 2, 3, 4, 5, 6,0,0,0,0};
        B = new int[]{2, 5, 7, 8};
        mergeKSortedList.merge(A,B, A.length-B.length,B.length);
        System.out.println(Arrays.toString(A));
    }

    public List<Integer> mergeArray(List<int[]> arrays) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((n1, n2) -> n1.value - n2.value);
        int i = 0;
        for (int[] item : arrays) {
            minHeap.offer(new Pair(i, 0, item[0]));
            i++;
        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            Pair current = minHeap.poll();
            result.add(current.value);
            if (current.position + 1 < arrays.get(current.index).length) {
                minHeap.add(new Pair(current.index, current.position + 1, arrays.get(current.index)[current.position + 1]));
            }
        }
        return result;
    }

    //https://leetcode.com/problems/merge-sorted-array/
    public void merge(int[] A, int[] B, int m, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }
        while (j >= 0) {
            A[k--] = B[j--];
        }
    }

    class Pair {
        int index;
        int position;
        int value;

        public Pair(int index, int position, int value) {
            this.index = index;
            this.position = position;
            this.value = value;
        }
    }
}
