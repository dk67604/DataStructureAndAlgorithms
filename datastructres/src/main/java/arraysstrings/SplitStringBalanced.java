package main.java.arraysstrings;

import java.util.concurrent.atomic.AtomicInteger;

public class SplitStringBalanced {

    private static boolean validateBalance(String s) {
        int openBracket = 0;
        int squareBracket = 0;
        int questionMark = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                openBracket++;
            } else if (ch == ')') {
                openBracket--;
            } else if (ch == '[') {
                squareBracket++;
            } else if (ch == ']') {
                squareBracket--;
            } else {
                questionMark++;
            }
        }
        if (questionMark > 0 && (openBracket == 0 && squareBracket == 0) && (questionMark % 2 == 0)) {
            return true;
        }

        while (questionMark > 0 && openBracket > 0) {
            openBracket--;
            questionMark--;
        }
        while (questionMark > 0 && squareBracket > 0) {
            squareBracket--;
            questionMark--;
        }

        return openBracket == 0 && squareBracket == 0 && questionMark == 0;
    }

    private static void fillMissingBracketsHelper(String s, int index, AtomicInteger count) {
        if (index == s.length()) return;

        String firstPart = s.substring(0, index);
        String secondPart = s.substring(index);

        boolean firstPartFlag = validateBalance(firstPart);
        if (firstPartFlag) {
            boolean secondPartFlag = validateBalance(secondPart);
            if (firstPartFlag && secondPartFlag)
                count.getAndIncrement();
        }
        fillMissingBracketsHelper(s, index + 1, count);


    }

    public static int fillMissingBrackets(String s) {
        AtomicInteger count = new AtomicInteger();
        fillMissingBracketsHelper(s, 1, count);
        return count.get();
    }

    public static void main(String[] args) {
        System.out.println(fillMissingBrackets("[(?][??["));
        System.out.println(fillMissingBrackets("(?]["));
        System.out.println(fillMissingBrackets("(((?"));
        System.out.println(fillMissingBrackets("????()"));
    }
}
