package main.java.topcodingquestion.treesandgraphs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToGetFood {
    public int getFood(char[][] grid) {
        int[][] dirs = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(findStart(grid));
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[queue.peek()[0]][queue.peek()[1]] = true;
        int step = 0;
        //Level order traversal to find the shortest path length
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];
                if (grid[x][y] == '#') return step;
                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX >= 0 && newY >= 0 && newX < m && newY < n && grid[newX][newY] !=
                            'X' && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        queue.add(new int[]{newX, newY});

                    }
                }
            }
            step++;
        }
        return -1;

    }

    private int[] findStart(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '*')
                    return new int[]{i, j};
            }
        }
        return null;
    }
}
