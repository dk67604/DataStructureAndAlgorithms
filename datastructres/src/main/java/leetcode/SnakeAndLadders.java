package main.java.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakeAndLadders {

    public int snakesAndLadders(int[][] board) {
        int N = board.length;

        //Store cell num and distance required to reach cell
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,0);
        //Used for BFS, store the visited cell
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()){
            int s = queue.poll();
            if(s == N*N) return map.get(s); //Reached to the terminal of board
            for(int s2 = s+1;s2<= Math.min(s+6,N*N);++s2){
                int rc = getBoardValue(s2,N);
                int r = rc/N,c = rc%N;
                int next = board[r][c]!=-1?board[r][c]:s2;
                if(!map.containsKey(next)){
                      queue.add(next);
                      map.put(next,map.get(s)+1);
                }
            }
        }

        return -1;
    }


    //Function get coord in square matrix
    private int getBoardValue(int s,int N){
        int quot = (s-1)/N;
        int rem = (s-1)%N;
        int row = N-1- quot;
        int col = row%2 != N%2?rem:N-1-rem;
        return row*N + col;//coordinate
    }
}
