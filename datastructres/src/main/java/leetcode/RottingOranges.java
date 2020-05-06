package main.java.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        int count_fresh=0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0;i<row; i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    count_fresh++;
                }
            }
        }
        if(count_fresh == 0)return 0;
        int count=0;
        while(!queue.isEmpty()){
            ++count;
            int size=queue.size();
            while(size>0){
                size--;
                int[] position = queue.poll();
                for(int[] dir:dirs){
                    int x=position[0]+dir[0];
                    int y= position[1] + dir[1];
                    if(x<0|| y<0  ||x>=row || y>=col||grid[x][y]==0|| grid[x][y]==2)continue;
                    grid[x][y]=2;
                    queue.offer(new int[]{x,y});
                    count_fresh--;
                }

            }
        }
        return count_fresh ==0?count-1:-1;
    }

    public static void main(String[] args) {
       // int[][] grid ={{2,1,1},{1,1,0},{0,1,1}};
        int[][] grid={{0,1}};
        RottingOranges rottingOranges =new RottingOranges();
        System.out.println(rottingOranges.orangesRotting(grid));
    }
}
