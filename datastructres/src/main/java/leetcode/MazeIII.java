package main.java.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MazeIII {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        PriorityQueue<Point> minHeap = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.dist == o2.dist ? o1.dir.compareTo(o2.dir) : o1.dist - o2.dist;
            }
        });
        minHeap.offer(new Point(0, ball[0], ball[1], ""));
        // arrays used for exploring 4 directions from a point
        char[] dstr = {'d', 'l', 'r', 'u'};
        int[][] dirs = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
        while (!minHeap.isEmpty()) {
            Point pt = minHeap.poll();
            if (pt.row == hole[0] && pt.col == hole[1]) {
                return pt.dir;
            }
            //mark current position visited
            visited[pt.row][pt.col] = true;
            for (int i = 0; i < dirs.length; i++) {
                int newRow = pt.row;
                int newCol = pt.col;
                int dist = pt.dist;
                String dir = pt.dir;
                // Explore current direction until hitting a wall or the hole
                while (newRow + dirs[i][0] >= 0 &&
                        newRow + dirs[i][0] < maze.length &&
                        newCol + dirs[i][1] >= 0 &&
                        newCol + dirs[i][1] < maze[0].length &&
                        maze[newRow + dirs[i][0]][newCol + dirs[i][1]] != 1) {
                    newRow += dirs[i][0];
                    newCol += dirs[i][1];
                    dist += 1;
                    if (newRow == hole[0] && newCol == hole[1]) {
                        break;
                    }
                }
                if (!visited[newRow][newCol]) {
                    minHeap.offer(new Point(dist, newRow, newCol, dir + dstr[i]));
                }
            }
        }
        return "impossible";
    }

    class Point {
        int dist; // distance from the wall
        int row;
        int col;
        String dir;

        public Point(int dist, int row, int col, String dir) {
            this.dist = dist;
            this.row = row;
            this.col = col;
            this.dir = dir;
        }
    }
}
