package main.java.arraysstrings;

import java.util.Arrays;
import java.util.TreeSet;

public class ReductorArray {

    public static void main(String[] args) {

        int[] A = {3, 1, 5};
        int[] B = {5, 6, 7};
        int c = process(A, B, 2);
        System.out.println("count: " + c);
    }

    private static int process(int[] A, int[] B, int d) {
        TreeSet<Integer> bTS = new TreeSet<>();
        for (int b : B) {
            bTS.add(b);
        }

        int count = 0;
        for (int a : A) {
            int aMin = a - d;
            Integer bMin = bTS.ceiling(aMin);
            if (null == bMin || bMin > (a + d)) {
                count++;
            }
        }
        return count;
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int len1 = arr1.length;
        int len2 = arr2.length;
        int i = 0, j = 0;
        int dist = 0;
        while (i < len1 && j < len2) {
            if (arr1[i] >= arr2[j]) {
                if ((arr1[i] - arr2[j]) > d) {
                    j += 1;
                } else {
                    i += 1;
                }
            } else {
                if ((arr2[j] - arr1[i]) > d) {
                    i += 1;
                    dist += 1;
                } else {
                    i += 1;
                }
            }
        }
        dist += len1 - i;
        return dist;
    }
}
