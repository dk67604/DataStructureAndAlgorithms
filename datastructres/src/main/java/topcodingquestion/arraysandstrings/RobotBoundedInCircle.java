package main.java.topcodingquestion.arraysandstrings;

public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//up,right,down,left
        int x = 0, y = 0, i = 0;
        for (int j = 0; j < instructions.length(); j++) {
            if (instructions.charAt(j) == 'R') {
                i = (i + 1) % 4; // return right index from dirs
            } else if (instructions.charAt(j) == 'L') {
                i = (i + 3) % 4; //return left index from dirs
            } else {
                x += dirs[i][0];
                y += dirs[i][1];
            }
        }
        return (x == 0 && y == 0) || i > 0;
    }
}
