package main.java.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CutOffTreeForGolfEvents {

    public int cutOffTree(List<List<Integer>> forest) {
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        if (forest == null && forest.size() == 0) return  0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        int tr = forest.size(),tc =forest.get(0).size();
        for(int i =0;i<tr;i++ ){
            for(int j =0 ; j<tc;j++){
                if(forest.get(i).get(j)>1)
                pq.offer(new int[]{i,j,forest.get(i).get(j)});
            }
        }

        int[] start = new int[2];
        int sum =0;
        while (!pq.isEmpty()){
            int[] tree = pq.poll();
            int minStep = bfs(forest,start,tree,tr,tc,dirs);
            if(minStep<0) return -1;
            sum+=minStep;
            start[0] = tree[0];
            start[1] = tree[1];
        }
        return sum;
    }


    private int bfs(List<List<Integer>> forest,int[] start,int[] tree,int tr,int tc,int[][] dirs){
        int step =0;
        boolean[][] visited = new boolean[tr][tc];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i =0; i<size;i++){
                int[] curr = queue.poll();
                if(curr[0] == tree[0] && curr[1] == tree[1]) return step;
                for (int[] dir:dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] +dir[1];
                    if(nr<0 || nr>=tr || nc<0 || nc>=tc || forest.get(nr).get(nc) ==0 ||
                    visited[nr][nc] == true) continue;
                    queue.offer(new int[]{nr,nc});
                    visited[nr][nc] = true;
                }
            }
            step++;
        }
        return -1;
    }


}
