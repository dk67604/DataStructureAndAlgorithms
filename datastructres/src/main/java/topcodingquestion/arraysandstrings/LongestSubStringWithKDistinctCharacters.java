package main.java.topcodingquestion.arraysandstrings;

import java.util.HashMap;
import java.util.Map;

//Given a string, find the length of the longest substring in it with no more than K distinct characters.
//You can assume that K is less than or equal to the length of the given string.
public class LongestSubStringWithKDistinctCharacters {
    public static int findLength(String str, int k) {
        if (str == null || str.length() == 0 || str.length() < k) return 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        int windowStart = 0, maxLen = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.getOrDefault(leftChar, 0) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++;
            }
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + findLength("cbbebi", 3));
    }
}
