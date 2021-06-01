package main.java.arraysstrings;

import java.util.*;
import java.util.stream.Collectors;

public class MinimalHeaviest {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(5);
        arr.add(3);
        arr.add(2);
        arr.add(4);
        arr.add(1);
        arr.add(2);
        MinimalHeaviest minimalHeaviest = new MinimalHeaviest();
        System.out.println(minimalHeaviest.minimalHeaviestSetA(arr));
        int[] input = new int[]{4, 2, 5, 1, 6};
        List<Integer> output = Arrays.stream(input).boxed().collect(Collectors.toList());
        System.out.println(minimalHeaviest.minimalHeaviestSetA(output));
        input = new int[]{3, 7, 5, 6, 2};
        output = Arrays.stream(input).boxed().collect(Collectors.toList());
        System.out.println(minimalHeaviest.minimalHeaviestSetA(output));
        input = new int[]{3, 1, 1};
        output = Arrays.stream(input).boxed().collect(Collectors.toList());
        System.out.println(minimalHeaviest.minimalHeaviestSetA(output));


    }

    public List<Integer> minimalHeaviestSetA(List<Integer> arr) {
        if (arr == null || arr.size() <= 1) return arr;
        List result = new ArrayList<>();
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        int target = sum / 2;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        pq.addAll(arr);
        int localSum = 0;
        while (localSum <= target) {
            int arrVal = pq.poll();
            localSum += arrVal;
            result.add(arrVal);
        }
        Collections.reverse(result);
        return result;
    }
}
