package main.java.topcodingquestion.treesandgraphs;

import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/number-of-distinct-islands/
public class NumberOfDistinctIsland {
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();//Store unique shape of island
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, "o");
                    grid[i][j] = -1; //mark visited
                    String s = sb.toString();
                    set.add(s);
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, int row, int col, StringBuilder sb, String dir) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] != 0 && grid[row][col] != -1) {
            sb.append(dir);
            grid[row][col] = -1;
            dfs(grid, row - 1, col, sb, "u");
            dfs(grid, row + 1, col, sb, "d");
            dfs(grid, row, col - 1, sb, "l");
            dfs(grid, row, col + 1, sb, "r");
            sb.append("b");//backtrack
            //Try Input [[1,1,0],[0,1,1],[0,0,0],[1,1,1],[0,1,0]], without sb.append('b') we get "ordr" for both islands, which means we move right,
            // down then right. In order to make them different,
            // we need to also record when we "hit a wall" and return.
            // With sb.append('b'), we now have "ordrbbbb" and "ordbrbbb" representing two different islands
        }
    }
}
