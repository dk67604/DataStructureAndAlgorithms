package main.java.leetcode;

import java.util.*;
import java.util.PriorityQueue;

public class ReorganizeString {

    //Intuition behind solution: count the number occurrences of each character using a hash map.
    // Create a max heap to hold the most frequently occurring character at its root at all times.
    // While you have two elements in your heap,
    // remove both characters and add them to your result string.
    // Once your loop breaks,
    // if the max heap has an element left in it and it occurs more than once,
    // return the empty string, otherwise, append it to your result and return your result.

    public String reorganizeString(String S) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c:S.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());
        StringBuilder result = new StringBuilder();

        while(maxHeap.size()>1){
            char current = maxHeap.remove();
            char next = maxHeap.remove();
            result.append(current);
            result.append(next);
            map.put(current,map.get(current)-1);
            map.put(next,map.get(next)-1);
            if(map.get(current) > 0)
                maxHeap.add(current);
            if(map.get(next) > 0)
                maxHeap.add(next);
        }
        if(!maxHeap.isEmpty()){
            char last = maxHeap.remove();
            if(map.get(last) > 1){
                return "";
            }
            result.append(last);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ReorganizeString reorganizeString = new ReorganizeString();
        System.out.println(reorganizeString.reorganizeString("aab"));
    }
}
