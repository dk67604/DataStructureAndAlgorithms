package main.java.topcodingquestion.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

// CTCI : Recursive and Dynamic Programing
// Problem 8.2
// Design an algorithm to find a path for the robot from the top left to the bottom left.
//Robot can move only in two direction right and down,but certain cell are ''off limits'
//such that robot can't step on them
class Point {
    int row;
    int col;

    Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return row == point.row &&
                col == point.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}

//To find the path from the origin, work backward.Starting from the last cell, try to find
// the path to each of its adjacent cells.
public class RobotInGrid {

    public ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> failedPoints = new HashSet<>();//Track already visited cell, to avoid visiting many times
        if (getPath(maze, maze.length, maze[0].length, path, failedPoints)) {
            return path;
        }
        return null;
    }

    private boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path,
                            HashSet<Point> failedPoints) {
        /* If out of bounds and not available, return */
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }
        Point p = new Point(row, col);
        //If we have already visited the cell,return
        if (failedPoints.contains(p)) {
            return false;
        }
        boolean isAtOrigin = row == 0 && col == 0;
        //If there's path from start location to my current location, add my location
        if (isAtOrigin || getPath(maze, row, col - 1, path, failedPoints)
                || getPath(maze, row - 1, col, path, failedPoints)) {
            path.add(p);
            return true;
        }
        failedPoints.add(p);//Cache the result
        return false;
    }
}
