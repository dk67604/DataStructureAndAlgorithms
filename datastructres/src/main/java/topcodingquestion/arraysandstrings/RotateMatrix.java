package main.java.topcodingquestion.arraysandstrings;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        RotateMatrix rotateMatrix = new RotateMatrix();
        int[][] matrix = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        rotateMatrix.print(matrix);
        rotateMatrix.rotate(matrix);
        System.out.println("90 degree rotated matrix");
        rotateMatrix.print(matrix);
        matrix = new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        rotateMatrix.print(matrix);
        rotateMatrix.rotate2(matrix);
        System.out.println("90 degree rotated matrix");
        rotateMatrix.print(matrix);
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];
                //left ->top
                matrix[first][i] = matrix[last - offset][first];
                //bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];
                //right -> bottom
                matrix[last][last - offset] = matrix[i][last];
                //top -> right
                matrix[i][last] = top;
            }
        }
    }

    public void rotate2(int[][] matrix){
        int N = matrix.length;
        for(int i =0; i < N/2; i++ ){
            for (int j = i; j< N-1-i;j++){
                int temp = matrix[i][j]; // leftmost top corner
                matrix[i][j] = matrix[N-1-j][i];
                matrix[N-1-j][i] = matrix[N-1-i][N-1-j];
                matrix[N-1-i][N-1-j] = matrix[j][N-1-i];
                matrix[j][N-1-i] = temp;
            }
        }
    }

    public void print(int[][] matrix) {
        for (int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }
    }
}
