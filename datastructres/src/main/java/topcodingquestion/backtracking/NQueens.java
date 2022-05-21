package main.java.topcodingquestion.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] chess = new char[n][n];
        for(int i = 0;i<n;i++){
            for (int j = 0; j<n; j++){
                chess[i][j] = '.';
            }
        }
        helper(chess,result,0);
        return result;
    }

    private void helper(char[][] chess,List<List<String>> result,int row){
        if(row == chess.length ){
            result.add(construct(chess));
            return;
        }
        for (int col = 0; col < chess.length;col++){
            if(isSafePlaceForQueen(chess,row,col)){
                chess[row][col] = 'Q';
                helper(chess,result,row+1);
                chess[row][col] ='.'; //backtrack

            }

        }
    }

    private boolean isSafePlaceForQueen(char[][] chess, int row, int col){
        for (int i = row -1,j=col ; i>=0;i--){
            if(chess[i][j] == 'Q' )
                return false;
        }
        for (int i = row -1,j=col-1;i>=0 &&  j>=0;i--,j--){
            if(chess[i][j] == 'Q' )
                return false;
        }
        for (int i = row -1,j=col+1;i>=0 &&  j<chess.length;i--,j++){
            if(chess[i][j] == 'Q' )
                return false;
        }
        return true;
    }
    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for (char[] chars : board) {
            String s = new String(chars);
            res.add(s);
        }
        return res;
    }

    public static void solve(boolean[][] board,int row, boolean[] cols, boolean[] ndiag,
                             boolean[] rdiag, String asf){
        if (row == board.length){
            System.out.println(asf + ".");
            return;
        }
        for (int col = 0; col < board[0].length; col++){
            if(!cols[col] && !ndiag[row + col] &&
                    !rdiag[row - col + board.length - 1]){
                board[row][col] = true;
                cols[col] = true; // block column
                ndiag[row + col] = true;
                rdiag[row - col + board.length - 1] = true;
                solve(board,row + 1, cols,ndiag,rdiag, asf + row + "-" + col+ " ,");
                //backtrack
                board[row][col] = false;
                cols[col] = false; // block column
                ndiag[row + col] = false;
                rdiag[row - col + board.length - 1] = false;
            }
        }
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        List<List<String>> answer = nQueens.solveNQueens(4);
        for (List<String> ans:answer){
            System.out.println(ans);
        }

        int n = 4;
        boolean[][] board = new boolean[n][n];
        boolean[] cols = new boolean[board[0].length];
        boolean[] ndiag = new boolean[2*n -1];
        boolean[] rdiag = new boolean[2*n -1];
        solve(board,0,cols,ndiag,rdiag,"");
    }
}
