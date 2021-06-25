package main.java.arraysstrings;

public class CheckSign {
    public int signOfProductNumbers(int[] A) {
        int noOfNegSign = 0;
        int sign = 1;
        for (int a : A) {
            if (a == 0) {
                sign = 0;
                break;
            } else if (a < 0) {
                noOfNegSign++;
            }
        }
        if (noOfNegSign % 2 > 0) {
            sign = -1;
        }
        return sign;
    }
}
