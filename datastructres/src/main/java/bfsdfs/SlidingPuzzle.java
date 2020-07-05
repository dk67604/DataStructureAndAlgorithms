package main.java.bfsdfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {

    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = serialize(board);
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int[][] dirs = new int[][]{{1,3,-1},{ 0, 2, 4 },
                { 1, 5,-1 }, { 0, 4,-1 }, { 1, 3, 5 }, { 2, 4,-1 }};
        int res = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i =0; i<size;i++){
                String curr = queue.poll();
                if(curr.equals(target))
                    return res;
                int zero = curr.indexOf('0');
                for(int dir:dirs[zero]){
                    if(dir == -1)break;
                    String next = swap(curr,zero,dir);
                    if(visited.contains(next))
                        continue;
                    queue.offer(next);
                    visited.add(next);

                }
            }
            res++;
        }
        return -1;
    }
    private String serialize(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<6; i++) {
            sb.append(board[i/3][i%3]);
        }
        return sb.toString();
    }



    private String swap(String str,int i,int j){
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i,str.charAt(j));
        sb.setCharAt(j,str.charAt(i));
        return sb.toString();
    }
}
