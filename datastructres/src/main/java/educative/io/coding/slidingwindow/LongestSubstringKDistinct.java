package main.java.educative.io.coding.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        if (str == null || str.length() == 0 || str.length() < k)
            throw new IllegalArgumentException();
        int windowStart = 0,maxLength = Integer.MIN_VALUE;
        Map<Character,Integer> charFrequencyMap = new HashMap<>();
        //intuition is to extend the sliding window keeping constraint of distinct character 'k' in the window
        for(int windowEnd = 0; windowEnd < str.length();windowEnd++){
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar,charFrequencyMap.getOrDefault(rightChar,0)+1);
            //shrink the sliding window until we are left with 'k' distinct character in the frequency map
            while (charFrequencyMap.size()>k){
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar,charFrequencyMap.get(leftChar)-1);//decrease the frequency of character going out window
                if(charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++; // shrink the window
            }
            maxLength = Math.max(maxLength,windowEnd - windowStart +1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
    }
