package main.java.topcodingquestion.treesandgraphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathWithObstacles {
    public int shortestPath(int[][] grid, int k){
        int step =0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        int[][] seen = new int[m][n]; // min obstacles elmination from 0,0 to x,y
        for(int i =0; i< m;i++){
            Arrays.fill(seen[i], Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,0});//x,y,obstacles
        seen[0][0] = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                if (cur[0] == m - 1 && cur[1] == n - 1)
                    return step;
                for (int[] dir : dirs) {
                    int x = dir[0] + cur[0];
                    int y = dir[1] + cur[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }
                    int obstacle = grid[x][y] + cur[2];
                    if (obstacle >= seen[x][y] || obstacle > k) {
                        continue;
                    }
                    seen[x][y] = obstacle;
                    queue.offer(new int[]{x, y, obstacle});
                }
            }
            ++step;
        }
            return -1;
        }
}
