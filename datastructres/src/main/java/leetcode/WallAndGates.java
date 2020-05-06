package main.java.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class WallAndGates {

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs  ={{-1,0},{0,1},{1,0},{0,-1}};
        int rows = rooms.length;
        int cols = rooms[0].length;
        for(int i =0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(rooms[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                size--;
                int[] position = queue.poll();
                for(int [] dir : dirs){
                    int x = position[0]+dir[0];
                    int y = position[1]+dir[1];
                    if(x<0 || y<0 || x>=rows || y>=cols || rooms[x][y] == -1 || rooms[x][y] == 0)continue;
                    if(rooms[x][y] == Integer.MAX_VALUE){
                        rooms[x][y]=rooms[position[0]][position[1]]+1;
                        queue.offer(new int[]{x,y});
                    }


                }
            }
        }

    }

    public static void main(String[] args) {
        WallAndGates wallAndGates = new WallAndGates();
        int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        wallAndGates.wallsAndGates(rooms);
    }
}
