package main.java.dsa_2024.algorithms.backtracking;

public class WordSearch {

    public boolean exist(char[][] board, String word){
        char[] w = word.toCharArray();
        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[0].length; y++){
                if(dfs(board, x, y, w, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int x, int y, char[] w, int i){
        if (i == w.length) return true;
        if ( x < 0 || y < 0 || x>= board.length || y >= board[0].length) return false;
        if(board[x][y] != w[i]) return false;
        board[x][y] ^= 256;
        boolean flag = dfs(board, x+1, y, w, i+1) || dfs(board, x-1, y, w, i+1) || dfs(board, x, y+1, w, i +1) || dfs(board, x, y-1, w, i+1);
        board[x][y] ^= 256;
        return flag;


    }

}
