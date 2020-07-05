package main.java.bfsdfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumKnightMoves {
    private final int[][] DIRECTIONS = new int[][]{
            {2,1}, {1, 2},
            {-1, 2}, {-2, 1},
            {-2, -1}, {-1, -2},
            {1, -2}, {2, -1}};
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        int result =0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++){
                int[] curr = queue.poll();
                int currX = curr[0];
                int currY = curr[1];
                if(x == currX && y == currY) return result;
                for (int[] dir : DIRECTIONS){
                    int newX = currX+dir[0];
                    int newY = currY+dir[1];
                    if(!visited.contains(newX+","+newY) && newX>=-1 && newY>=-1){
                            visited.add(newX+","+newY);
                            queue.offer(new int[]{newX,newY});
                    }
                }
            }
            result++;
        }
        return -1;
    }
}
