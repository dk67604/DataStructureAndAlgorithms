package main.java.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWaterII {
    public class Cell{
        int row;
        int col;
        int height;
        public Cell(int row,int col,int height){
            this.row = row;
            this.col = col;
            this.height =height;
        }
    }

    public int trapRainWater(int[][] heights){
        if(heights == null || heights.length ==0||heights[0].length==0) return 0;

        //Use Min-Heap to store the boundary height
        PriorityQueue<Cell> pq = new PriorityQueue<>(1,new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return o1.height - o2.height;
            }
        });

        int m = heights.length; // rows
        int n = heights[0].length; //cols
        boolean[][] visited = new boolean[m][n];
        //Initially, add all the Cells which are on borders to the queue.
        //Left to Right
        for(int i = 0;i<m;i++){
            visited[i][0] =true;
            visited[i][n-1] = true;
            pq.offer(new Cell(i,0,heights[i][0]));
            pq.offer(new Cell(i,n-1,heights[i][n-1]));
        }

        //Top to bottom;
        for (int i =0;i<n;i++){
            visited[0][i] = true;
            visited[m-1][i] = true;
            pq.offer(new Cell(0,i,heights[0][i]));
            pq.offer(new Cell(m-1,i,heights[m-1][i]));
        }
        //Use BFS approach,from borders use shortest height and check its neighbour.
        //if the neighbour height is shorter,collect the water it can trap and update neighbour with
        // maximum height which will acts as boundary in the current path
        int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        int res =0;
        while (!pq.isEmpty()){
            Cell cell = pq.poll();
            for (int[] dir:dirs){
                int row = cell.row+dir[0];
                int col = cell.col+dir[1];
                if(row>=0 && row<m && col>=0 && col<n &&!visited[row][col]){
                    visited[row][col] = true;
                    res+=Math.max(0,cell.height - heights[row][col]);
                    pq.offer(new Cell(row,col,Math.max(heights[row][col],cell.height)));
                }
            }
        }
        return res;
    }

}
