package main.java.topcodingquestion.sortingandsearching;

public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Search from top-right corner in the given matrix
        int col = matrix[0].length -1;
        int row = 0;
        while(col>=0 && row < matrix.length){
            if(target == matrix[row][col]){
                return true;
            }
            else if(target < matrix[row][col]){
                col--; // move a step back i.e. toward the left
            }
            else if(target > matrix[row][col] ){
                row++; // move a step down i.e. toward the bottom
            }
        }
        return false;
    }
}
