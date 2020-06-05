package main.java.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIsland {
    int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        int res =0;
        for (int i =0;i<grid.length;i++){
            for (int j =0; j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid,i,j,0,0,sb);
                    String s = sb.toString();

                    if(!set.contains(s)){
                        res++;
                        set.add(s);
                    }
                }

            }
        }
        return res;

    }

    public void dfs(int[][] grid,int i,int j,int xpos,int ypos,StringBuilder sb){
        grid[i][j] = 0; //mark visited
        sb.append(xpos+""+ypos);
        for (int[] dir:dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y] == 0) continue;
            dfs(grid,x,y,xpos+dir[0],ypos+dir[1],sb);
        }
    }
}
