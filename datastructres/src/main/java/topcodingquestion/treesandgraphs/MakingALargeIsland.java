package main.java.topcodingquestion.treesandgraphs;

public class MakingALargeIsland {

    public int largestIsland(int[][] grid){
        int max =0, m = grid.length,n=grid[0].length;
        boolean hasZero = false;
        for(int i =0; i< grid.length;i++){
            for(int j = 0; j< grid[0].length;j++){
                if(grid[i][j] == 0){
                    grid[i][j] = 1;
                    max = Math.max(max,dfs(i,j,grid, new boolean[m][n]));
                    if(max == (m*n)) return max;
                    grid[i][j] = 0; // backtracking
                    hasZero = true;
                }
            }
        }
        return hasZero?max:m*n;
    }
    private int dfs(int i,int j, int[][]grid,boolean[][] visited ){
        if(i < 0 || j < 0 || i>=grid.length || j >= grid[0].length ||grid[i][j] == 0 || visited[i][j]) return 0;
        visited[i][j] = true;
        int result = 1 + dfs(i-1,j,grid,visited)+ dfs(i+1,j,grid,visited) + dfs(i,j-1,grid,visited)+
                dfs(i,j+1,grid,visited);
        return result;
    }
}
