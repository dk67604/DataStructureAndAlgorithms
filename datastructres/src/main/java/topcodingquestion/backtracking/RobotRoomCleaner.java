package main.java.topcodingquestion.backtracking;

import java.util.HashSet;
import java.util.Set;

interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    void turnLeft();

    void turnRight();

    // Clean the current cell.
    void clean();
}

public class RobotRoomCleaner {
    public void cleanRoom(Robot robot) {
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Set<String> visited = new HashSet<>();
        backtrack(0, 0, dirs, visited, robot, 0);

    }

    private void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    private void backtrack(int row, int col, int[][] dirs, Set<String> visited, Robot robot, int d) {
        visited.add(row + "->" + col);
        robot.clean();
        for (int i = 0; i < 4; ++i) {
            int newD = (d + i) % 4;
            int newRow = row + dirs[newD][0];
            int newCol = col + dirs[newD][1];
            if (!visited.contains(newRow + "->" + newCol) && robot.move()) {
                backtrack(newRow, newCol, dirs, visited, robot, newD);
                goBack(robot);
            }

            robot.turnRight();
        }
    }
}
