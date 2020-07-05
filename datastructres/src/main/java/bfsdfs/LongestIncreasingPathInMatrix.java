package main.java.bfsdfs;

public class LongestIncreasingPathInMatrix {
        public static final int[][] dirs = {{0,1},{-1,0},{1,0},{0,-1}};
        public int longestIncreasingPath(int[][] matrix) {
            if(matrix == null || matrix.length == 0) return 0;
            int ans =1;
            int m = matrix.length;
            int n = matrix[0].length;
            // track visited cell and store the max len to that perticular cell
            int[][] cache = new int[m][n];
            for (int i=0;i<m;i++){
                for (int j=0;j<n;j++){
                    int len = dfs(i,j,m,n,cache,matrix);
                    ans= Math.max(len,ans);
                }
            }
            return ans;

        }

        public int dfs(int i,int j,int m ,int n,int[][] cache,int[][] matrix){
            if(cache[i][j]!=0)return cache[i][j];
            int ans =1;
            for(int[] dir:dirs){
                int x = i+dir[0];
                int y = j+dir[1];
                if(x<0 || x>=m || y<0 ||y>=n || matrix[x][y]<=matrix[i][j])
                    continue;
                int len = 1+dfs(x,y,m,n,cache,matrix);
                ans = Math.max(len,ans);
            }
            cache[i][j]=ans;
            return ans;

        }
}
