package main.java.topcodingquestion.backtracking;

import java.util.Arrays;

public class SudokuSolver {

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.solveSudoku(board);

    }

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char po = '1'; po <= '9'; po++) {
                        if (isValid(board, i, j, po)) {
                            board[i][j] = po;
                            if (solve(board))
                                return true;
                            else
                                board[i][j] = '.'; //backtrack otherwise go back
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char val) {
        //check in all column for a row
        for (int j = 0; j < board[0].length; j++) {
            if (board[row][j] == val)
                return false;
        }
        // check in all row for a column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == val)
                return false;
        }
        int smi = row / 3 * 3; // corner index of a sub-matrix
        int smj = col / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[smi + i][smj + j] == val)
                    return false;
            }
        }
        return true;
    }
}
