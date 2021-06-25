package main.java.topcodingquestion.treesandgraphs;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/number-of-provinces/
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[m];
        int connComp = 0;
        for (int i = 0; i < m; i++) { //start from source city
            queue.add(i);
            if (visited[i] == 0) {
                while (!queue.isEmpty()) {
                    int s = queue.poll();
                    visited[s] = 1;
                    for (int j = 0; j < m; j++) {//explore other city
                        if (isConnected[s][j] == 1 && visited[j] == 0) {
                            queue.add(j);
                        }
                    }

                }
                connComp++;
            }

        }
        return connComp;
    }
}
