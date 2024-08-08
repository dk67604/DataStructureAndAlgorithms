package main.java.dsa_2024.algorithms;

public class UniquePathIII {

    public int uniquePathsIII(int[][] grid){
        int zero =0, a= 0, b=0;
        int ROWS = grid.length;
        int COLS = grid[0].length;
        for(int r =0; r < ROWS; r++ ){
            for(int c = 0; c< COLS; c++){
                if( grid[r][c] == 0){
                    zero++;
                }
                else if( grid[r][c] == 1){
                    a = r;
                    b = c;
                }
            }
        }
        return dfs(grid,ROWS, COLS, a, b, zero);
    }

    private int dfs(int[][] grid, int ROWS, int COLS, int x, int y, int zero){
        if(x < 0 | y < 0 || x >= ROWS || y >= COLS || grid[x][y] == -1)
            return 0;
        if(grid[x][y] == 2)
            return zero == -1 ? 1 : 0;
        grid[x][y] = -1;
        zero--;
        int totalCount = dfs(grid, ROWS, COLS, x+1, y, zero) + dfs(grid, ROWS, COLS, x -1, y, zero) +
                         dfs(grid, ROWS, COLS, x, y + 1, zero) + dfs(grid, ROWS, COLS, x, y - 1, zero);
        grid[x][y] = 0;
        zero++;
        return totalCount;
    }

}
