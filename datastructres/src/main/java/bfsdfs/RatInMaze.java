package main.java.bfsdfs;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
    static List<int[]> res = new ArrayList<>();
    /* A utility function to check
       if x, y is valid index for N*N maze */
    boolean isSafe(
            int maze[][], int x, int y)
    {
        // if (x, y outside maze) return false
        return (x >= 0 && x < maze.length && y >= 0
                && y < maze[0].length && maze[x][y] == 1);
    }


    /* A recursive utility function to solve Maze
    problem */
    boolean solveMazeUtil(int maze[][], int x, int y,
                          int sol[][])
    {
        // if (x, y is goal) return true
        if (x == maze.length - 1 && y == maze[0].length - 1
                && maze[x][y] == 1) {
            sol[x][y] = 1;
            res.add(new int[]{x,y});
            return true;
        }

        // Check if maze[x][y] is valid
        if (isSafe(maze, x, y) == true) {
            // mark x, y as part of solution path
            sol[x][y] = 1;
            res.add(new int[]{x,y});
            /* Move forward in x direction */
            if (solveMazeUtil(maze, x + 1, y, sol))
                return true;

            /* If moving in x direction doesn't give
            solution then Move down in y direction */
            if (solveMazeUtil(maze, x, y + 1, sol))
                return true;

            /* If none of the above movements works then
            BACKTRACK: unmark x, y as part of solution
            path */
            sol[x][y] = 0;
            res.remove(res.size()-1);
            return false;
        }

        return false;
    }
    /* A utility function to print
  solution matrix sol[N][N] */
    void printSolution(int sol[][])
    {
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol[0].length; j++)
                System.out.print(
                        " " + sol[i][j] + " ");
            System.out.println();
        }
        for (int[] ans:res){
            System.out.println(ans[0]+","+ans[1]);
        }
    }

    boolean mazeII(int[][] maze){
        int[][] sol = new int[maze.length][maze[0].length];
        if (solveMazeUtil(maze, 0, 0, sol) == false) {
            System.out.print("Solution doesn't exist");
            return false;
        }

        printSolution(sol);
        return true;
    }

    public static void main(String args[])
    {
        RatInMaze rat = new RatInMaze();
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };


        rat.mazeII(maze);
    }
}
