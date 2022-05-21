package main.java.topcodingquestion.arraysandstrings;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/swap-for-longest-repeated-character-substring/
 * You are given a string text. You can swap two of the characters in the text.
 *
 * Return the length of the longest substring with repeated characters.
 *
 *
 *
 * Example 1:
 *
 * Input: text = "ababa"
 * Output: 3
 * Explanation: We can swap the first 'b' with the last 'a', or the last 'b' with the first 'a'. Then, the longest repeated character substring is "aaa" with length 3.
 * Example 2:
 *
 * Input: text = "aaabaaa"
 * Output: 6
 * Explanation: Swap 'b' with the last 'a' (or the first 'a'), and we get longest repeated character substring "aaaaaa" with length 6.
 * Example 3:
 *
 * Input: text = "aaaaa"
 * Output: 5
 * Explanation: No need to swap, longest repeated character substring is "aaaaa" with length is 5.
 *
 *
 * Constraints:
 *
 * 1 <= text.length <= 2 * 104
 * text consist of lowercase English characters only.
 */
public class SwapForLongestRepeatedCharacterSubString {
    public int maxRepOpt1(String text) {
        int windowStart = 0;
        int maxLength = 0;
        int maxRepeatLetterCount = 0;
        char maxCountChar = '#';
        int[] freq = new int[26];
        int n = text.length();
        for (int i = 0; i < n; i++) {
            freq[text.charAt(i) - 'a']++;
        }
        Map<Character, Integer> letterFrequencyMap = new HashMap<>();
        for(int windowEnd = 0; windowEnd < text.length();  windowEnd++){
            char rightChar = text.charAt(windowEnd);

            letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar,0) + 1);
            if (maxRepeatLetterCount <= letterFrequencyMap.get(rightChar) ){
                maxRepeatLetterCount = letterFrequencyMap.get(rightChar);
                maxCountChar = rightChar;
            }

            while(windowEnd - windowStart + 1 - maxRepeatLetterCount > 1 || windowEnd - windowStart + 1 > freq[maxCountChar -'a'] ){
                char leftChar = text.charAt(windowStart);
                letterFrequencyMap.put(leftChar,letterFrequencyMap.get(leftChar)-1);
                windowStart++;
            }
            maxLength = Math.max(maxLength,windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
