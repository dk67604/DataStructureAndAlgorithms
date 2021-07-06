package main.java.ctci.moderate;

import java.util.Arrays;
import java.util.HashSet;

public class SumSwap {
    //Driver method
    public static void main(String[] args) {
        int[] array1 = {1, 4, 2, 1, 1, 2};
        int[] array2 = {3, 6, 3, 3};
        SumSwap sumSwap = new SumSwap();
        int[] values = sumSwap.findSwapValuesI(array1, array2);
        System.out.println(Arrays.toString(values));
    }

    //The problem can be solved by finding
    // sum(array1) -a + b = sum(array2) -b + a
    // On solving above equation we get, a - b = (sumA - sumB)/2
    // It means that numerator must be even, let's call right side term -> target
    // this makes the equation a - b = target -> b = a - target
    // Now we can solve using hash table
    public int[] findSwapValuesI(int[] array1, int[] array2) {
        Integer target = getTarget(array1, array2);
        if (target == null) return null;
        return findDifference(array1, array2, target);
    }

    private Integer getTarget(int[] array1, int[] array2) {
        int sumA = Arrays.stream(array1).sum();
        int sumB = Arrays.stream(array2).sum();
        if ((sumA - sumB) % 2 != 0) return null;
        return (sumA - sumB) / 2;
    }

    private int[] findDifference(int[] array1, int[] array2, Integer target) {
        HashSet<Integer> uniques = new HashSet<Integer>();
        for (int num : array2) {
            uniques.add(num);
        }
        for (int one : array1) {
            int two = one - target;
            if (uniques.contains(two)) {
                return new int[]{one, two};
            }
        }
        return null;
    }
}
