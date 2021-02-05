package main.java.leetcode.backtracking;

public class TotalUniquePathInMaze {
    public static void main(String[] args) {
        int maze[][] =
                {
                        {1, 1, 1, 1},
                        {1, 1, 0, 1},
                        {0, 1, 0, 1},
                        {1, 1, 1, 1}
                };

        // stores number of unique paths from source to destination
        int count = 0;

        TotalUniquePathInMaze totalUniquePathInMaze = new TotalUniquePathInMaze();
        // start from source cell (0, 0)
        count = totalUniquePathInMaze.countPaths(maze);

        System.out.println("Total number of unique paths are " + count);
    }

    public int countPaths(int[][] maze) {
        int N = maze.length;
        int[] count = new int[1];
        count = helper(maze, new boolean[N][N], 0, 0, N, count);
        return count[0];

    }

    private boolean isValidCell(int x, int y, int N) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return false;
        }
        return true;
    }

    private int[] helper(int[][] maze, boolean[][] visited, int x, int y, int N, int[] count) {
        // if destination (bottom-rightmost cell) is found,
        // increment the path count
        if (x == N - 1 && y == N - 1) {
            count[0]++;
            return count;
        }
        // mark current cell as visited
        visited[x][y] = true;
        // if current cell is valid and open cell
        if (isValidCell(x, y, N) && maze[x][y] == 1) {
            //go down
            if (x + 1 < N && !visited[x + 1][y])
                count = helper(maze, visited, x + 1, y, N, count);

            //go up
            if (x - 1 >= 0 && !visited[x - 1][y])
                count = helper(maze, visited, x - 1, y, N, count);
            //go right
            if (y + 1 < N && !visited[x][y + 1])
                count = helper(maze, visited, x, y + 1, N, count);
            //go left
            if (y - 1 >= 0 && !visited[x][y - 1])
                count = helper(maze, visited, x, y - 1, N, count);
        }
        //backtrack from current cell and remove it from current path
        visited[x][y] = false;
        return count;
    }
}
