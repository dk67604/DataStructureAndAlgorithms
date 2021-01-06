package main.java.eleofproginterview.Graph;

import java.util.*;

public class FillSurroundingRegion {

    public static void fillSurroundedRegions (char[][] board) {
        if(board.length == 0){
            return;
        }

        List<List<Boolean>> visited  = new ArrayList<>();
        for(int i = 0; i < board.length;++i){
            visited.add(new ArrayList<>(Collections.nCopies(board[i].length,false)));
        }
        // Identifies the region that are reachable via white path starting from first or
        // last column
        for (int i = 0 ; i<board.length; i++){
            if(board[i][0] == 'O' && !visited.get(i).get(0)){
                markBoundaryRegions(i,0,board,visited);
            }
            if(board[i][board[i].length-1] == 'O'
                    && !visited.get(i).get(board[i].length-1)){
                markBoundaryRegions(i,board[i].length-1,board,visited);
            }
        }
        //Identifies the region that are reachable via white path starting from first or
        // last row
        for (int j = 0 ; j<board[0].length; j++){
            if(board[0][j] == 'O' && !visited.get(0).get(j)){
                markBoundaryRegions(0,j,board,visited);
            }
            if(board[board.length-1][j] == 'O'
                    && !visited.get(board.length-1).get(j)){
                markBoundaryRegions(board.length-1,j,board,visited);
            }
        }
        //Mark the surrounded white regions as black
        for (int i = 1; i< board.length -1;i++){
            for (int j = 1; j< board[i].length-1;j++){
                if (board[i][j] == 'O' && !visited.get(i).get(j)){
                    board[i][j] = 'X';
                }
            }
        }

    }

    


    private static void markBoundaryRegions(int i, int j, char[][] board,
                                            List<List<Boolean>> visited){
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(i,j));
        visited.get(i).set(j,true);
        while (!queue.isEmpty()){
            Coordinate curr = queue.poll();
            final int DIRS[][] = {{0,1},{1,0},{-1,0},{0,-1}};
            for (int[] dir : DIRS){
                Coordinate next = new Coordinate(curr.x+dir[0], curr.y +dir[1]);
                if(next.x >=0 && next.x < board.length && next.y >= 0
                   && next.y < board[next.x].length
                   && board[next.x][next.y] == 'O'
                   && !visited.get(next.x).get(next.y)){
                    visited.get(next.x).set(next.y,true);
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        System.out.println("Before:");
        System.out.println(Arrays.deepToString(board));
        fillSurroundedRegions(board);
        System.out.println("After:");
        System.out.println(Arrays.deepToString(board));

    }
}
