package main.java.dsa_2024.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

public class SwimWater {

    private int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public int swimInWater(int[][] grid) {
        int len = grid.length;
        if (len == 1) {
            return 0;
        }

        boolean[][] seen = new boolean[len][len];
        seen[0][0] = true;

        Queue<Integer[]> minHeap = new PriorityQueue<>((n1, n2) -> n1[0] - n2[0]);
        minHeap.add(new Integer[] { grid[0][0], 0, 0 });

        int result = 0;
        while (!minHeap.isEmpty()) {
            Integer[] cur = minHeap.poll();
            result = Math.max(result, cur[0]);
            if (cur[1] == len - 1 && cur[2] == len - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int x = cur[1] + dirs[i][0];
                int y = cur[2] + dirs[i][1];

                if (x < 0 || x >= len || y < 0 || y >= len || seen[x][y]) {
                    continue;
                }

                minHeap.add(new Integer[] { grid[x][y], x, y });
                seen[x][y] = true;
            }
        }
        return result;

    }

}
