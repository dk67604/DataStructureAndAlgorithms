package main.java.arraysstrings;

import java.util.*;

public class ShoppingGifts {

    public static long getNumberOfOptions(List<Integer> priceOfJeans,
                                          List<Integer> priceOfShoes,
                                          List<Integer> priceOfSkirts,
                                          List<Integer> priceOfTops, int dollars) {
        long result = 0;
        Map<Long, Long> map = new HashMap<>();
        for (int priceOfSkirt : priceOfSkirts) {
            for (int priceOfTop : priceOfTops) {
                long sum = priceOfSkirt + priceOfTop;
                map.put(sum, map.getOrDefault(sum, 0l) + 1);
            }
        }
        Map<Long, Long> map_lookup = new HashMap<>();
        for (int priceOfJean : priceOfJeans) {
            for (int priceOfShoe : priceOfShoes) {
                long sum = priceOfJean + priceOfShoe;
                map_lookup.put(sum, map_lookup.getOrDefault(sum, 0l) + 1);
            }
        }
        for (Map.Entry<Long, Long> entry1 : map.entrySet()) {
            for (Map.Entry<Long, Long> entry2 : map_lookup.entrySet()) {
                if (entry1.getKey() + entry2.getKey() <= (long) dollars) {
                    result += entry1.getValue() >= entry2.getValue() ? entry1.getValue() : entry2.getValue();
                }
            }
        }
        return result;

//         List<List<Integer>> items = new ArrayList<>();
//         items.add(priceOfJeans);
//         items.add(priceOfShoes);
//         items.add(priceOfSkirts);
//         items.add(priceOfTops);
//         return shoppingOptionCount(items,dollars);
    }

    public static int shoppingOptionCount(List<List<Integer>> items, int budget) {
        if (budget < 0)
            return 0;

        if (items.size() == 1)
            return singleItemShoppingCount(items.get(0), budget);

        int count = 0;
        for (int p : items.get(0)) {
            if (p <= budget) {
                List<List<Integer>> newItems = new ArrayList<>(items);
                newItems.remove(0);
                count += shoppingOptionCount(newItems, budget - p);
            }
        }
        return count;
    }

    public static int singleItemShoppingCount(List<Integer> prices, int budget) {
        int count = 0;
        for (int p : prices) {
            if (p <= budget)
                count += 1;
        }
        return count;
    }

    private static long helper(Map<Long, Long> map, long sum, int dollars) {
        long difference = (long) dollars - sum;
        long valid = 0;
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            if (entry.getKey() <= difference) {
                valid += entry.getValue();
            }
        }
        return valid;
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