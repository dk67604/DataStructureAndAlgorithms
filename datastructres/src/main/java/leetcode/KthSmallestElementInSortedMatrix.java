package main.java.leetcode;

import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        // (a[0], a[1]) and (b[0], b[1]) are positions in the matrix
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) ->Integer.compare(matrix[a[0]][a[1]],
                matrix[b[0]][b[1]]));
        int n = matrix.length;
        for (int i =0;i<n;i++){
            minHeap.offer(new int[]{i,0});//Initialise with the first column
        }

        while (--k>0) {
            int[] p = minHeap.poll();//Remove the smallest elements from the matrix (k-1) times
            if(++p[1]<n){
                minHeap.offer(p); //add the next element in same if it exists
            }
        }
        return matrix[minHeap.peek()[0]][minHeap.peek()[1]];
    }
}
