package main.java.topcodingquestion.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//https://leetcode.com/problems/palindrome-permutation-ii/
public class PalindromicPermutation {

    /**
     * This method to generate palindromic permutation, it requires the permutation generated
     * satisfies palindrome requirement. To have a string to be palindrome we need at most one character
     * to have frequency 1 and all other characters to have frequency even
     *
     * @param s
     * @return
     */
    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        Character odd = null;
        int odds = 0;
        int len = 0;
        for (char ch : countMap.keySet()) {
            int freq = countMap.get(ch);
            if (freq % 2 == 1) {
                odd = ch;
                odds++;
            }
            countMap.put(ch, freq / 2); //We need the frequency reduce by half
            len += freq / 2;
        }
        if (odds > 1) {
            return result;
        }
        backtrack(1, len, countMap, odd, "", result);
        return result;
    }

    private void backtrack(int currentPos, int length, Map<Character, Integer> countMap, Character odd,
                           String answerSoFar, List<String> result) {

        if (currentPos > length) {
            String rev = "";
            for (int i = answerSoFar.length() - 1; i >= 0; i--) {
                rev += answerSoFar.charAt(i);
            }
            String res = answerSoFar;
            if (odd != null) {
                res += odd;
            }
            res += rev;
            result.add(res);
            return;
        }
        for (char ch : countMap.keySet()) {
            int freq = countMap.get(ch);
            if (freq == 0) continue;
            countMap.put(ch, freq - 1);

            backtrack(currentPos + 1, length, countMap, odd, answerSoFar + ch, result);
            countMap.put(ch, freq);//backtrack to explore other options to add in final result
        }
    }


}
