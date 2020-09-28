package main.java.educative.io.coding.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.
 *
 * You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
 *
 * Write a function to return the maximum number of fruits in both the baskets.
 */
public class MaxFruitCountOf2Types {
    public static int findLength(char[] arr) {
        int windowStart = 0,maxLength = 0;
        Map<Character,Integer> fruitFrequencyMap = new HashMap<>();
        //intuition is to extend the sliding window keeping constraint of 2 distinct fruits in the window
        for(int windowEnd = 0;windowEnd < arr.length; windowEnd++){
            fruitFrequencyMap.put(arr[windowEnd],fruitFrequencyMap.getOrDefault(arr[windowEnd],0)+1);
            //shrink the sliding window,until we're left with '2' fruits in the frequency map
            while (fruitFrequencyMap.size() > 2){
                fruitFrequencyMap.put(arr[windowStart],fruitFrequencyMap.get(arr[windowStart])-1);
                if(fruitFrequencyMap.get(arr[windowStart]) == 0){
                    fruitFrequencyMap.remove(arr[windowStart]);
                }
                windowStart++; // shrink the window
            }
            maxLength = Math.max(maxLength,windowEnd - windowStart +  1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
}
