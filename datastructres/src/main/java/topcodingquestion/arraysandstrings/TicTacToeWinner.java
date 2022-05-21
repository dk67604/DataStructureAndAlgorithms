package main.java.topcodingquestion.arraysandstrings;

/**
 * https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
 * Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:
 *
 * Players take turns placing characters into empty squares ' '.
 * The first player A always places 'X' characters, while the second player B always places 'O' characters.
 * 'X' and 'O' characters are always placed into empty squares, never on filled ones.
 * The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
 * The game also ends if all squares are non-empty.
 * No more moves can be played if the game is over.
 * Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli]. return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw". If there are still movements to play return "Pending".
 *
 * You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
 * Output: "A"
 * Explanation: A wins, they always play first.
 * Example 2:
 *
 *
 * Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
 * Output: "B"
 * Explanation: B wins.
 * Example 3:
 *
 *
 * Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
 * Output: "Draw"
 * Explanation: The game ends in a draw since there are no moves to make.
 */
public class TicTacToeWinner {
    public String tictactoe(int[][] moves) {
        int n = 3;
        // Use rows and cols to record the value on each row and each column.
        // diag1 and diag2 to record value on diagonal or anti-diagonal.
        int[] rows = new int[n];
        int[] cols = new int [n];
        int player =1;
        int diag = 0, ant_diag =0;
        // Two players having value of 1 and -1, player_1 with value = 1 places first.

        for(int[] move : moves){
            int row =  move[0], col = move[1];
            // Update the row value and column value.

            rows[row] += player;
            cols[col] += player;
            // If this move is placed on diagonal or anti-diagonal,
            // we shall update the relative value as well.
            if (row == col){
                diag += player;
            }
            if (row + col == n-1){
                ant_diag +=player;
            }
            // Check if this move meets any of the winning conditions.

            if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n ||
            Math.abs(diag) == n || Math.abs(ant_diag) == n ){
                return player == 1? "A" : "B";
            }

            // If no one wins so far, change to the other player alternatively.
            // That is from 1 to -1, from -1 to 1.
            player *=-1;
        }

        // If all moves are completed and there is still no result, we shall check if
        // the grid is full or not. If so, the game ends with draw, otherwise pending.
        return moves.length == n * n ?"Draw" :"Pending";
    }
}
