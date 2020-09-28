package main.java.arraysstrings;

import java.util.HashMap;
import java.util.Map;

public class NumberOfFractionsThatSumUpTo1 {
    public static void main(String[] args) {
        int[] x1 = { 1, 1, 2 }, y1 = { 3, 2, 3 };
        int[] x2 = { 1, 1, 1 }, y2 = { 2, 2, 2 };
        int[] x3 = { 1, 2, 3, 1, 2, 12, 8, 4 }, y3 = { 5, 10, 15, 2, 4, 15, 10, 5 };
        System.out.println(solution(x1, y1));
        System.out.println(solution(x2, y2));
        System.out.println(solution(x3, y3));
    }

    public static int solution(int[] A, int[] B) {
        int count = 0, mod = 1000000007;
        Map<String, Integer> hMap = new HashMap<String, Integer>();
        for(int i=0; i<A.length;i++) {
            int numerator = A[i];
            int denominator = B[i];
            // to simplify the divisions like 3/9 into 1/3
            int gcd = gcd(numerator, denominator);
            numerator = numerator/gcd;
            denominator = denominator/gcd;
            // Finding the target (1 - numerator/denominator) in Map
            String expectedString = (denominator-numerator)+"/"+denominator;
            if(hMap.containsKey(expectedString)) {
                count = (count + hMap.get(expectedString))%mod;
            }
            String currentString = numerator+"/"+denominator;
            //Update the map with numerator/denominator count
            hMap.put(currentString, (hMap.getOrDefault(currentString, 0) + 1)%mod);
        }

        return count;
    }

    public static int gcd(int first, int second) {
        if(second == 0)
            return first;
        return gcd(second, first%second);
    }
}