package main.java.arraysstrings;

public class Pattern {
    public static void printLowerRight(int rows){
        for(int i = 0; i<rows;i++){
            for(int j = 0;j<=2*(rows-i);j++) {
                System.out.print(" ");
            }
            for (int j = 0; j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        printLowerRight(6);
    }
}
