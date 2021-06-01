package main.java.topcodingquestion.arraysandstrings;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean rowZero = false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        //determine which row/col has to be set zeero
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    matrix[0][c] = 0;
                    if (r > 0) {
                        matrix[r][0] = 0;
                    } else {
                        rowZero = true;
                    }
                }
            }
        }
        //set most of row/col values to zero
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[0][c] == 0 || matrix[r][0] == 0) {
                    matrix[r][c] = 0;
                }

            }
        }
        //Check if first column need to set to zero
        if (matrix[0][0] == 0) {
            for (int r = 0; r < rows; r++) {
                matrix[r][0] = 0;
            }
        }
        //Check if first row need to set to zero
        if (rowZero) {
            for (int c = 0; c < cols; c++) {
                matrix[0][c] = 0;
            }
        }
    }
}
