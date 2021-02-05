package main.java.leetcode.backtracking;

import java.util.Stack;

public class PrintAllShortestRoutesInRectangularGrid {
    // Recursive function to get all shortest routes in a rectangular grid
    // that start at the cell(i,j) and end at the last cell(M-1,N-1).
    public static void printPaths(int[][] mat, Stack<Integer> route, int i, int j, int M, int N) {
        //include current cell in route
        route.add(mat[i][j]);
        // if last cell is reached
        if (i == M - 1 && j == N - 1) {
            System.out.println(route);
        } else {
            //move down
            if (i + 1 < M)
                printPaths(mat, route, i + 1, j, M, N);
            //move diagonally
            if (i + 1 < M && j + 1 < N)
                printPaths(mat, route, i + 1, j + 1, M, N);
            //move right
            if (j + 1 < N)
                printPaths(mat, route, i, j + 1, M, N);
        }
        // backtrack -remove the current cell from route
        route.pop();

    }

    public static void printPaths(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;
        Stack<Integer> route = new Stack<>();
        printPaths(mat, route, 0, 0, M, N);
    }

    public static void main(String[] args) {
        int[][] mat =
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };

        printPaths(mat);
    }
}
