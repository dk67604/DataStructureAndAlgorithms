package main.java.topcodingquestion.treesandgraphs;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegion {
    public static void main(String[] args) {

    }

    public void solve(char[][] board) {
        if (board.length == 0) return;
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i == 0 || i == board.length - 1) || (j == 0 || j == board[0].length - 1) && board[i][j] == 'O') {
                    queue.add(new Pair(i, j));
                }
            }
        }
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            if (current.x >= 0 && current.x < board.length && current.y >= 0 && current.y < board[0].length
                    && board[current.x][current.y] == '0') {
                board[current.x][current.y] = 'D';
                queue.add(new Pair(current.x - 1, current.y));
                queue.add(new Pair(current.x + 1, current.y));
                queue.add(new Pair(current.x, current.y - 1));
                queue.add(new Pair(current.x, current.y + 1));
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '0') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'D') {
                    board[i][j] = '0';
                }
            }
        }
    }

    public void solveII(char[][] board) {
        if (board.length == 0) return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i == 0 || i == board.length - 1) || (j == 0 || j == board[0].length - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'D') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] == 'O') {
            board[row][col] = 'D';
            dfs(board, row + 1, col);
            dfs(board, row - 1, col);
            dfs(board, row, col + 1);
            dfs(board, row, col - 1);
        }
    }

    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
