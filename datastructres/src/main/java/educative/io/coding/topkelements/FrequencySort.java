package main.java.educative.io.coding.topkelements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    public static String sortCharacterByFrequency(String str) {
        Map<Character,Integer> charFrequencyMap = new HashMap<>();
        for(char c : str.toCharArray()){
            charFrequencyMap.put(c,charFrequencyMap.getOrDefault(c,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((e1,e2) -> e2.getValue() - e1.getValue());
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> entry : charFrequencyMap.entrySet()){
            maxHeap.add(entry);
        }
        while (!maxHeap.isEmpty()){
            Map.Entry<Character,Integer> entry = maxHeap.poll();
            for (int i = 0;i<entry.getValue();i++){
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String result = FrequencySort.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = FrequencySort.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }
}
