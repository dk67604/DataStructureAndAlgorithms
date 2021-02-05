package main.java.arraysstrings;

public class RussianPeasantAlgorithm {
    public static int multiply(int a, int b) {
        // flag to store if result is positive or negative
        boolean isNegative = false;

        // if both numbers are negative, make both numbers
        // positive as result will be positive anyway
        if (a < 0 && b < 0) {
            a = -a;
            b = -b;
        }

        // if only a is negative, make it positive
        // and mark result as negative
        if (a < 0) {
            a = -a;
            isNegative = true;
        }

        // if only b is negative, make it positive
        // and mark result as negative
        if (b < 0) {
            b = -b;
            isNegative = true;
        }
        int res = 0;
        // While second number doesn't become 1
        while (b != 0) {

            // If second number becomes odd,
            // add the first number to result
            if ((b & 1) != 0) {
                res += a;
            }
            // Double the first number
            // and halve the second number
            a = a << 1;
            b = b >> 1;
        }
        return (isNegative) ? -res : res;
    }

    public static void main(String[] args) {
        System.out.println(multiply(-8, -9));
    }
}
