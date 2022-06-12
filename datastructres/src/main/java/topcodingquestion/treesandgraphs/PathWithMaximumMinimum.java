package main.java.topcodingquestion.treesandgraphs;

import java.util.PriorityQueue;

public class PathWithMaximumMinimum {
    public int maximumMinimumPath(int[][] A) {
        int[] dir = {0,1,0,-1,0};
        int R = A.length,C=A[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->(b[0]-a[0]));
        queue.offer(new int[]{A[0][0],0,0});
        boolean[][] seen = new boolean[R][C];
        seen[0][0]= true;
        int result = Integer.MAX_VALUE;
        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            result = Math.min(result,curr[0]);
            if(curr[1] == R-1 && curr[2] == C-1)
                break;
            for(int d=0;d<4;++d){
                int r = curr[1] + dir[d];
                int c = curr[2]+dir[d+1];
                if(r<0||r>=R || c<0|| c>=C || seen[r][c])
                    continue;
                queue.offer(new int[]{A[r][c],r,c});
                seen[r][c]=true;
            }
        }
        return result;
    }
}
