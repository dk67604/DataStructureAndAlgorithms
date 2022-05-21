package main.java.topcodingquestion.treesandgraphs;

import java.util.*;

public class MinFlipBinaryMatrixToZero {
    public int minFlips(int[][] matrix) {
        int[][] dirs = {{0,0},{0,1},{1,0},{-1,0},{0,-1}};
        int start = 0, m = matrix.length, n = matrix[0].length;
        //Convert the matrix into int
        for(int i = 0; i< m;i++){
            for (int j =0; j< n; j++){
                start |= matrix[i][j] << (i*n + j);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        Set<Integer> seen = new HashSet<>();
        seen.add(start);
        int step =0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int sz =0; sz<size;sz++){
                int cur = queue.poll();
                if( cur == 0)
                    return step;
                //traverse all m*n bits of cur
                for(int i = 0; i< m;i++) {
                    for (int j = 0; j < n; j++) {
                        int next = cur;
                        for(int[] dir: dirs){
                            int r = i + dir[0];
                            int c = j + dir[1];
                            if(r>=0 && c>=0 && r < m && c < n){ //flip the cell and neighbors
                                next ^= 1 << (r*n + c);
                            }
                        }
                        if(!seen.contains(next)){
                            seen.add(next);
                            queue.offer(next);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
