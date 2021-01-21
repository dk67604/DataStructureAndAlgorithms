package main.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    public static void main(String[] args) {
        String[] ops = new String[]{"5", "2", "C", "D", "+"};
        BaseballGame baseballGame = new BaseballGame();
        System.out.println(baseballGame.calPoints(ops));
        ops = new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(baseballGame.calPoints(ops));
    }

    public int calPoints(String[] ops) {
        List<Integer> list = new ArrayList<>();

        int runningSum = 0;
        for (String op : ops) {
            if (isNumeric(op)) {
                list.add(Integer.valueOf(op));
                runningSum += list.get(list.size() - 1);

            } else if (op == "C") {
                int lastOne = list.get(list.size() - 1);
                list.remove(list.size() - 1);
                runningSum -= lastOne;

            } else if (op == "D") {
                list.add(list.get(list.size() - 1) * 2);
                runningSum += list.get(list.size() - 1);

            } else if (op == "+") {
                list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
                runningSum += list.get(list.size() - 1);

            }
        }
        return runningSum;

    }
}
