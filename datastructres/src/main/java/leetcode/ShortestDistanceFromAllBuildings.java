package main.java.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
 *Step1: start from every point 1 (building point), doing BFS traversal to fill out distance array
 *Step 2: find the minimum distance array
 * @param dp: store distance sum to all building for every point 0. Update values when we do BFS traversal
 * @param reach: store number of buildings that every point 0 can reach. Used for checking if current point is valid
 *             while we want to find final result
 * @param countBuilding: count total number of point 1
 */

public class ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        int n =  grid.length;
        int m = grid[0].length;
        int[][] distance = new int[n][m];
        int[][] reach = new int[n][m];
        int countBuilding = 0;
        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n;i++){
            for (int j =0;j< m;j++){
                if(grid[i][j] == 1){
                    queue.offer(new int[]{i,j});
                    bfs(queue,grid,distance,reach,n,m,dirs);
                    countBuilding++;
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n;i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] ==  0 && reach[i][j] == countBuilding){
                    result = Math.min(result,distance[i][j]);
                }
            }
        }
        return result == Integer.MAX_VALUE?-1:result;
    }

    private void bfs(Queue<int[]> queue,int[][] grid,int[][] distance,int[][] reach,int n, int m,int[][] dirs){
        int level =1;
        boolean[][] visited = new boolean[n][m];
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i =0; i<size;i++){
                int[] currPoint = queue.poll();
                int x = currPoint[0];
                int y = currPoint[1];
                for (int [] dir:dirs){
                    int dx = x + dir[0];
                    int dy = y + dir[1];
                    if(dx < 0 || dx > n-1 || dy < 0 || dy > m-1 || grid[dx][dy]!=0 || visited[dx][dy]){
                        continue;
                    }
                    visited[dx][dy] = true;
                    queue.offer(new int[]{dx,dy});
                    distance[dx][dy]+=level;
                    reach[dx][dy]++;
                }
            }
            level++;
        }
    }

}
