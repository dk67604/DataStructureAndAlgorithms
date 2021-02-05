package main.java.leetcode.backtracking;

public class LongestPathInMatrix {
    static int max_dist = 0;
    static int dist = 0;

    public static void main(String[] args) {
        // input matrix
//        int mat[][] =
//                {
//                        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
//                        { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
//                        { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
//                        { 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
//                        { 1, 0, 0, 0, 1, 1, 1, 1, 1, 1 },
//                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
//                        { 1, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
//                        { 1, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
//                        { 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
//                        { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }
//                };

        int mat[][] =
                {
                        {1, 0, 0},
                        {1, 1, 1},
                        {0, 0, 1}
                };


        // (0,0) are the source cell coordinates and (5, 7) are the
        // destination cell coordinates
        LongestPathInMatrix longestPathInMatrix = new LongestPathInMatrix();
        int max_dist = longestPathInMatrix.findLongestPath(mat, 0, 0, 2, 2);

        System.out.println("Maximum length path is " + max_dist);
    }

    public int findLongestPath(int[][] mat, int srcX, int srcY, int destX, int destY) {

        // construct a matrix to keep track of visited cells
        int N = mat.length;
        int[][] visited = new int[N][N];
        return helper(mat, visited, srcX, srcY, destX, destY, max_dist, dist, N);
    }

    private int helper(int[][] mat, int[][] visited, int i, int j, int x, int y,
                       int max_dist, int dist, int N) {
        // if the destination is not possible from the current cell
        if (mat[i][j] == 0) {
            return 0;
        }
        //if the destination is found, update `max_dist`
        if (i == x && j == y) {
            return Integer.max(max_dist, dist);
        }
        // set `(i, j)` cell as visited
        visited[i][j] = 1;
        //go to bottom cell
        if (isValid(i + 1, j, N) && (isSafe(mat, visited, i + 1, j))) {
            max_dist = helper(mat, visited, i + 1, j, x, y, max_dist, dist + 1, N);
        }
        //go to right cell
        if (isValid(i, j + 1, N) && (isSafe(mat, visited, i, j + 1))) {
            max_dist = helper(mat, visited, i, j + 1, x, y, max_dist, dist + 1, N);
        }
        // go to top cell
        if (isValid(i - 1, j, N) && (isSafe(mat, visited, i - 1, j))) {
            max_dist = helper(mat, visited, i - 1, j, x, y, max_dist, dist + 1, N);
        }
        // go to the left cell
        if (isValid(i, j - 1, N) && (isSafe(mat, visited, i, j - 1))) {
            max_dist = helper(mat, visited, i, j - 1, x, y, max_dist, dist + 1, N);
        }
        // backtrack: remove `(i, j)` from the visited matrix
        visited[i][j] = 0;
        return max_dist;
    }

    // Check if it is possible to go to position `(x, y)` from
    // the current position. The function returns false if the cell
    // has a value 0, or it is already visited.
    private boolean isSafe(int[][] mat, int[][] visited, int x, int y) {
        if (mat[x][y] == 0 || visited[x][y] != 0) {
            return false;
        }
        return true;
    }

    private boolean isValid(int x, int y, int N) {
        if (x < 0 || y < 0 || x >= N || y >= N)
            return false;
        return true;
    }
}
