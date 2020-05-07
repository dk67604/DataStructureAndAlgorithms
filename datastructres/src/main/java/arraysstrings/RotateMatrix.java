package main.java.arraysstrings;

import java.util.Arrays;

public class RotateMatrix {

    public void rotate(int[][] matrix){
        int n = matrix .length;
        for(int layer = 0; layer<n/2;layer++){
            int first = layer;
            int last =  n-1-layer;
            for(int j =first;j<last;j++){
                int offset = j-first;
                int temp = matrix[first][j]; // Save top element
                matrix[first][j] = matrix[last-offset][first]; // left -> top
                matrix[last-offset][first] = matrix[last][last-offset]; //bottom -> left
                matrix[last][last-offset]= matrix[j][last]; // right -> bottom
                matrix[j][last] = temp; //top -> bottom
            }
        }
    }

    public static void main(String[] args) {
        RotateMatrix rotateMatrix = new RotateMatrix();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotateMatrix.rotate(matrix);
        for (int[] m:matrix){
            System.out.println(Arrays.toString(m));
        }
    }
}
