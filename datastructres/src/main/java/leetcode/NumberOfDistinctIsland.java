package main.java.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIsland {
    int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        NumberOfDistinctIsland numberOfDistinctIsland = new NumberOfDistinctIsland();
        System.out.println(numberOfDistinctIsland.numDistinctIslands(grid));
    }

    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, "o");
                    grid[i][j] = 0; //mark visited
                    String s = sb.toString();
                    set.add(s);
                }

            }
        }
        return set.size();

    }

    public void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return;
        sb.append(dir);
        grid[i][j] = 0;
        dfs(grid, i - 1, j, sb, "u");
        dfs(grid, i + 1, j, sb, "d");
        dfs(grid, i, j + 1, sb, "r");
        dfs(grid, i, j - 1, sb, "l");
        sb.append("b"); //backtrack
    }

}
