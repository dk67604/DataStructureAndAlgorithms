package main.java.educative.io.coding.topkelements;

import java.util.*;

public class RearrangeStringKDistanceApart {
    public static String reorganizeString(String str, int k) {
        if (k<=1) return str;
        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        for(char c: str.toCharArray()){
            characterFrequencyMap.put(c, characterFrequencyMap.getOrDefault(c,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
                (e1,e2)-> e2.getValue() - e1.getValue());
        maxHeap.addAll(characterFrequencyMap.entrySet());
        Queue<Map.Entry<Character,Integer>> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            sb.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() -1);
            queue.offer(currentEntry);
            if(queue.size() == k){
                Map.Entry<Character, Integer> entry = queue.poll();
                if(entry.getValue() > 0)
                    maxHeap.add(entry);
            }

        }
        return sb.length() == str.length()?sb.toString():"";
    }

    public static void main(String[] args) {
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aab", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
    }
}