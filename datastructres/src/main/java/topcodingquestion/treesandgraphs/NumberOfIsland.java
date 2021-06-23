package main.java.topcodingquestion.treesandgraphs;

public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        int totalIsland = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ++totalIsland;
                }
            }
        }
        return totalIsland;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] != '0' && grid[row][col] != 'T') {
            grid[row][col] = 'T';
            dfs(grid, row + 1, col);
            dfs(grid, row - 1, col);
            dfs(grid, row, col + 1);
            dfs(grid, row, col - 1);
        }
    }
}
