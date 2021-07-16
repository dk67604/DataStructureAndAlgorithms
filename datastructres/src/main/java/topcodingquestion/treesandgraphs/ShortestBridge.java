package main.java.topcodingquestion.treesandgraphs;
//https://leetcode.com/problems/shortest-bridge/discuss/189321/Java-DFS-find-the-island-greater-BFS-expand-the-island

import java.util.LinkedList;
import java.util.Queue;

// 1. dfs to find an island, mark it in `visited`
// 2. bfs to expand this island
public class ShortestBridge {
    public int shortestBridge(int[][] A) {
        int m = A.length, n = A[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        //Step 1
        for (int i = 0; i < m; i++) {
            if (found)
                break;
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    dfs(A, visited, queue, i, j, dirs);
                    found = true;
                    break;
                }
            }
        }
        //Step 2
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int i = cur[0] + dir[0];
                    int j = cur[1] + dir[1];
                    if (i >= 0 && j >= 0 && i < m && j < n && !visited[i][j]) {
                        if (A[i][j] == 1) {
                            return step;
                        }
                        queue.offer(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private void dfs(int[][] A, boolean[][] visited, Queue<int[]> queue, int i, int j, int[][] dirs) {
        if (i < 0 || j < 0 || i >= A.length || j >= A[0].length || visited[i][j] || A[i][j] == 0)
            return;
        visited[i][j] = true;
        queue.offer(new int[]{i, j});
        for (int[] dir : dirs) {
            dfs(A, visited, queue, i + dir[0], j + dir[1], dirs);
        }
    }

}
