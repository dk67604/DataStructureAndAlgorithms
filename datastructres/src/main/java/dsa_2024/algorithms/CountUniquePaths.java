package main.java.dsa_2024.algorithms;

public class CountUniquePaths {

    public int countUniquePath(int[][] grid){
        int rows =grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];
        return dfs(grid, 0, 0, rows, cols, visited);
    }

    private int dfs(int[][] grid, int r, int c, int rows, int cols, int[][] visited){
        if (Math.min(r, c) < 0 || r == rows || c == cols ||
        visited[r][c] == 1 || grid[r][c] ==1){
            return 0;
        }
        if (r == rows - 1 && c == cols - 1){
            return 1;
        }
        visited[r][c] = 1;
        int count = 0;
        count += dfs(grid, r + 1, c, rows, cols, visited);
        count += dfs(grid, r - 1, c, rows, cols, visited);
        count += dfs(grid, r, c + 1, rows, cols, visited);
        count += dfs(grid, r, c - 1, rows, cols, visited);
        visited[r][c] = 0; // backtracking
        return count;
    }

}
