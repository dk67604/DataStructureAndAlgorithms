package main.java.leetcode;

public class SurroundRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        int rows = board.length;
        int cols = board[0].length;

        //check first and last col
        for (int i=0;i<rows;i++){
            if (board[i][0] == 'O')
                dfs(i,1,board);
            if (board[i][cols-1] == 'O')
                dfs(i,cols-2,board);
        }

        // check first row and last row
        for (int i=0;i<cols;i++){
            if (board[0][i] == 'O')
                dfs(1,i,board);
            if (board[rows-1][i] == 'O')
                dfs(rows-2,i,board);
        }

        // flip O to X, '*' to 'O',
        // skip the boulders
        for (int i=1;i<rows-1;i++){
            for (int j=1;j<cols-1;j++){
                if (board[i][j] == '*')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    public void dfs(int i,int j, char[][]board){
        if (i<=0 || j<=0||i>=board.length-1||j>=board[0].length-1||board[i][j] == 'X')
            return;
        if (board[i][j] == '*')
            return;
        if (board[i][j] == 'O')
            board[i][j] = '*';


        dfs(i+1,j,board);
        dfs(i-1,j,board);
        dfs(i,j+1,board);
        dfs(i,j-1,board);
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        SurroundRegions surroundRegions = new SurroundRegions();
        surroundRegions.solve(board);
    }
}
