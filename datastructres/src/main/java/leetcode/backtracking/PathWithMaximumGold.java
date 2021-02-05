package main.java.leetcode.backtracking;

public class PathWithMaximumGold {
    int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxGold = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                maxGold = Math.max(maxGold, findMaxGold(grid, m, n, r, c));
            }
        }
        return maxGold;
    }

    private int findMaxGold(int[][] grid, int m, int n, int r, int c) {
        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == 0) return 0;
        int origin = grid[r][c];
        grid[r][c] = 0; // visited
        int maxGold = 0;
        for (int[] d : dirs) {
            maxGold = Math.max(maxGold, findMaxGold(grid, m, n, r + d[0], c + d[1]));
        }
        grid[r][c] = origin; //backtrack
        return maxGold + origin;
    }
}
