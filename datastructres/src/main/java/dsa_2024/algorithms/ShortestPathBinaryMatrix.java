package main.java.dsa_2024.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class ShortestPathBinaryMatrix {
     private static final int[][] dirs = {
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, 1}, {1, 1}, {1, 0},
        {1, -1}, {0, -1}
    };
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0)
            return -1;
        int currentDistance = 1;
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        queue.add(new Point(0, 0));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int nodesAtCurrentDistance = queue.size();
            for (int i = 0; i < nodesAtCurrentDistance; i++) {
                Point point = queue.poll();
                if (point.x == grid.length - 1 && point.y == grid[0].length - 1) {
                    return currentDistance;
                }
                for (Point neighbour : getNeighbours(point.x, point.y, grid)) {
                    int neighbourRow = neighbour.x;
                    int neighbourCol = neighbour.y;
                    if (visited[neighbourRow][neighbourCol]) {
                        continue;
                    }
                    visited[neighbourRow][neighbourCol] = true;
                    queue.add(new Point(neighbourRow, neighbourCol));
                }
            }
            currentDistance++;
        }
        return -1;
    }

    private List<Point> getNeighbours(int row, int col, int[][] grid) {
        List<Point> neighbours = new ArrayList<>();
        for (int i = 0; i < dirs.length; i++) {
            int newRow = dirs[i][0] + row;
            int newCol = dirs[i][1] + col;
            if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length
                    || grid[newRow][newCol] != 0) {
                continue;
            }
            neighbours.add(new Point(newRow, newCol));
        }
        return neighbours;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
