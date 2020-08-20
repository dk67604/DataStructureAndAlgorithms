package main.java.leetcode;

/**
 * On a 2-dimensional grid, there are 4 types of squares:
 *
 * 1 represents the starting square.  There is exactly one starting square.
 * 2 represents the ending square.  There is exactly one ending square.
 * 0 represents empty squares we can walk over.
 * -1 represents obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 */

public class UniquePathIII {
    public int uniquePathsIII(int[][] g) {
        int sr=0,sc=0,empty=0;
        for(int i = 0; i<g.length; i++){
            for(int j =0; j<g[0].length;j++){
                if(g[i][j] == 0){
                    ++empty;
                }else if(g[i][j]==1){
                    sr=i;
                    sc=j;
                }
            }
        }
        return dfs(g,sr,sc,-1,empty);
    }

    public int dfs(int[][] g,int x,int y, int count,int need){
        if(x<0 || y< 0 ||x>=g.length || y >= g[0].length || g[x][y] == -1) return 0;
        if(g[x][y] ==2){
            if(count == need) return 1;
            else return 0;
        }
        g[x][y] = -1; //mark visited in current dfs path
        int total = dfs(g, x-1, y, count+1, need);
        total+= dfs(g, x, y+1, count+1, need);
        total+= dfs(g, x+1, y, count+1, need);
        total+= dfs(g, x, y-1, count+1, need);
        g[x][y] = 0; // unmaark for the next dfs
        return total;

    }


}
