package main.java.dsa_2024.algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public int orangesRotting(int[][] grid){
        int ROWS = grid.length, COLS = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    fresh +=1;
                }
            }
        }
        int count = 0;
        int[][] dirs = {{1,0},{0,1}, {-1,0}, {0,-1} };
        while (!queue.isEmpty() && fresh !=0) {
            count +=1;
            int sz = queue.size();
            for(int i =0; i < sz; i++){
                int[] rotten = queue.poll();
                int r = rotten[0], c = rotten[1];
                for(int[] dir : dirs){
                    int x = r + dir[0];
                    int y = c + dir[1];
                    if( x >= 0 && y >= 0 && x < ROWS && y < COLS && grid[x][y] == 1){
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                        fresh -=1;
                    }
                }
            }
        }
        return fresh == 0 ? count : -1;
    }

}
