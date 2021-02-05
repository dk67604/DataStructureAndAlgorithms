package main.java.leetcode;

//Use memoized version of dfs to solve this problem
public class LongestIncreasingPathInMatrix {
    final static int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        int[][] matrix =
                {{9, 9, 4},
                        {6, 6, 8},
                        {2, 1, 1}};
        LongestIncreasingPathInMatrix longestIncreasingPathInMatrix = new LongestIncreasingPathInMatrix();
        System.out.println(longestIncreasingPathInMatrix.longestIncreasingPath(matrix));
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int ans = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        //track the visited cell and store the max len to that particular cell
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(i, j, m, n, cache, matrix);

                ans = Math.max(ans, len);
            }
        }
        return ans;
    }

    private int dfs(int i, int j, int m, int n, int[][] cache, int[][] matrix) {
        if (cache[i][j] != 0) return cache[i][j];
        int ans = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = i + dir[1];
            if (x < 0 || y < 0 || x >= m || y >= n || matrix[x][y] <= matrix[i][j])
                continue;
            int len = 1 + dfs(x, y, m, n, cache, matrix);

            ans = Math.max(len, ans);
        }
        cache[i][j] = ans;
        return ans;
    }
}
