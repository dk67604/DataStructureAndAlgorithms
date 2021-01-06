package main.java.leetcode.backtracking;

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
                chess[row][col] ='.';

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
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        nQueens.solveNQueens(4);
    }
}
