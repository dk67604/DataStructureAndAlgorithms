package main.java.arraysstrings;

import java.util.Arrays;
import java.util.List;

class Cart {
    int priceOfJean;
    int priceOfShoe;
    int priceOfSkirt;
    int priceOfTop;
    int balance;

    public Cart(int priceOfJean,
                int priceOfShoe,
                int priceOfSkirt,
                int priceOfTop,
                int balance) {
        this.priceOfJean = priceOfJean;
        this.priceOfShoe = priceOfShoe;
        this.priceOfSkirt = priceOfSkirt;
        this.priceOfTop = priceOfTop;
        this.balance = balance;
    }
}

public class ShoppingGiftII {
    public static long getNumberOfOptions(List<Integer> priceOfJeans,
                                          List<Integer> priceOfShoes,
                                          List<Integer> priceOfSkirts,
                                          List<Integer> priceOfTops, int dollars) {
        long result = 0;
        long[] dp = new long[dollars + 1];
        for (int p1 : priceOfJeans) {
            for (int p2 : priceOfShoes) {
                if (p1 + p2 >= 0 && p1 + p2 <= dollars) {
                    dp[p1 + p2] += 1;
                }
            }
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i] += dp[i - 1];
        }
        for (int q1 : priceOfSkirts) {
            for (int q2 : priceOfTops) {
                if (dollars - (q1 + q2) >= 0 && dollars - (q1 + q2) <= dollars) {
                    result += dp[dollars - (q1 + q2)];
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        List<Integer> priceOfJeans = Arrays.asList(2, 3);
        List<Integer> priceOfShoes = Arrays.asList(4);
        List<Integer> priceOfSkirts = Arrays.asList(2);
        List<Integer> priceOfTops = Arrays.asList(1, 2, 3);

        int dollars = 10;
        System.out.println(getNumberOfOptions(priceOfJeans,
                priceOfShoes, priceOfSkirts, priceOfTops, dollars));
        priceOfJeans = Arrays.asList(2, 3);
        priceOfShoes = Arrays.asList(4);
        priceOfSkirts = Arrays.asList(2, 3);
        priceOfTops = Arrays.asList(1, 2);
        dollars = 10;
        System.out.println(getNumberOfOptions(priceOfJeans,
                priceOfShoes, priceOfSkirts, priceOfTops, dollars));
        priceOfJeans = Arrays.asList(4);
        priceOfShoes = Arrays.asList(3, 4, 1);
        priceOfSkirts = Arrays.asList(3, 2);
        priceOfTops = Arrays.asList(4);
        dollars = 12;
        System.out.println(getNumberOfOptions(priceOfJeans,
                priceOfShoes, priceOfSkirts, priceOfTops, dollars));
        priceOfJeans = Arrays.asList(1);
        priceOfShoes = Arrays.asList(1);
        priceOfSkirts = Arrays.asList(1);
        priceOfTops = Arrays.asList(1);
        dollars = 3;
        System.out.println(getNumberOfOptions(priceOfJeans,
                priceOfShoes, priceOfSkirts, priceOfTops, dollars));
    }
}
