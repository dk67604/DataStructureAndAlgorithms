package main.java.topcodingquestion.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *Given a string s, return all the palindromic permutations (without duplicates) of it.
 *
 * You may return the answer in any order. If s has no palindromic permutation, return an empty list.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aabb"
 * Output: ["abba","baab"]
 * Example 2:
 *
 * Input: s = "abc"
 * Output: []
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 16
 * s consists of only lowercase English letters.
 */
public class PalindromePermutation {
    public List<String> generatePalindromes(String s){
        List<String> result = new ArrayList<>();
        Map<Character,Integer> countMap = new HashMap<>();
        for (char ch : s.toCharArray()){
            countMap.put(ch,countMap.getOrDefault(ch,0)+1);
        }
        Character odd = null;
        int odds = 0;
        int len = 0;
        for (char ch: countMap.keySet()){
            int freq = countMap.get(ch);
            if(freq %2 ==1){
                odd = ch;
                odds++;
            }
            countMap.put(ch, freq/2);
            len += freq/2;
        }
        if(odds > 1) return result;
        backtrack(1,len,countMap,odd,"",result);
        return result;
    }

    private void backtrack(int currentPos, int length, Map<Character,Integer> countMap,
                           Character odd, String answerSoFar, List<String> result){

        if(currentPos > length){
            String rev = "";
            for (int i = answerSoFar.length()-1;i>=0;i--){
                rev += answerSoFar.charAt(i);
            }
            String res = answerSoFar;
            if(odd != null){
                res +=odd;
            }
            res += rev;
            result.add(res);
            return;
        }

        for(char ch: countMap.keySet()){
            int freq = countMap.get(ch);
            if(freq == 0) continue;
            countMap.put(ch, freq -1);
            backtrack(currentPos+1, length, countMap,odd ,answerSoFar + ch,result);
            countMap.put(ch,freq);
        }
    }

    public static void main(String[] args) {
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        System.out.println(palindromePermutation.generatePalindromes("aabb"));
    }
}
