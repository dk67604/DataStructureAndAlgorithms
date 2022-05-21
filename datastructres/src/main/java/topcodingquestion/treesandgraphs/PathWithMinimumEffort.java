package main.java.topcodingquestion.treesandgraphs;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
 *
 * A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
 *
 * Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
 * Output: 2
 * Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
 * This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
 * Example 2:
 *
 *
 *
 * Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
 * Output: 1
 * Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
 * Example 3:
 *
 *
 * Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * Output: 0
 * Explanation: This route does not require any effort.
 *
 *
 * Constraints:
 *
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 106
 */

class Point{
    int x;
    int y;
    int difference;

    public Point(int x, int y, int difference){
        this.x  = x;
        this.y = y;
        this.difference = difference;
    }
}

public class PathWithMinimumEffort {
    // Approach using Dijkstra Algorithm
    public int minimumEffortPath(int[][] heights) {
        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
        int row = heights.length;
        int col = heights[0].length;
        int[][] differenceMatrix = new int[row][col];
        for(int[] eachRow : differenceMatrix){
            Arrays.fill(eachRow, Integer.MAX_VALUE);
        }
        differenceMatrix[0][0] = 0;
        PriorityQueue<Point> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.difference,b.difference));
        boolean[][] visited = new boolean[row][col];
        queue.add(new Point(0,0,differenceMatrix[0][0]));
        while(!queue.isEmpty()){
            Point point = queue.poll();
            visited[point.x][point.y] = true;
            if(point.x == row -1 && point.y == col -1)
                return point.difference;
            for(int[] dir: dirs){
                int newX = point.x + dir[0];
                int newY = point.y + dir[1];
                if(isValidPoint(newX, newY, row,col) && !visited[newX][newY]){
                    int currentDifference = Math.abs(heights[newX][newY] - heights[point.x][point.y]);
                    int maxDifference = Math.max(currentDifference,differenceMatrix[point.x][point.y]);
                    if(differenceMatrix[newX][newY] > maxDifference){
                        differenceMatrix[newX][newY] =  maxDifference;
                        queue.add(new Point(newX,newY,maxDifference));
                    }
                }
            }
        }
        return differenceMatrix[row-1][col -1];

    }
    private boolean isValidPoint(int x, int y, int row, int col){
        return x>=0 && x<=row-1 && y >=0 && y <= col -1;
    }
}
