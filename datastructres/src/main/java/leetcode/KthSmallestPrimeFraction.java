package main.java.leetcode;

import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int n = A.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) ->
                Integer.compare(A[a[0]]*A[n-1-b[1]],A[n-1-a[1]]*A[b[0]]));

        for (int i =0;i<A.length;i++){
            minHeap.offer(new int[]{i,0});
        }
        while (--K>0){
            int[] p = minHeap.poll();
            if(++p[1]<n){
                minHeap.offer(p);
            }
        }
        return new int[]{A[minHeap.peek()[0]],A[n-1-minHeap.peek()[1]]};
    }
}