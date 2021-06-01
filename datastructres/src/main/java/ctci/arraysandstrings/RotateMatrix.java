package main.java.ctci.arraysandstrings;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        RotateMatrix rotateMatrix = new RotateMatrix();
        int[][] matrix = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        rotateMatrix.print(matrix);
        rotateMatrix.rotate(matrix);
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

    public void print(int[][] matrix) {
        for (int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }
    }
}
