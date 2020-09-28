package main.java.educative.io.coding.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string and a pattern, find out if the string contains any permutation of the pattern.
 */
public class StringPermutation {
    public static boolean findPermutation(String str, String pattern) {
        int windowStart = 0, matched =0;
        Map<Character,Integer> charFrequencyMap = new HashMap<>();
        for(char ch: pattern.toCharArray())
            charFrequencyMap.put(ch,charFrequencyMap.getOrDefault(ch,0)+1);
        // intuition is to match all the character in 'charFrequencyMap' with the current window
        // try to extend the sliding window
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar)){
                //decrement the frequency of the matched character
                charFrequencyMap.put(rightChar,charFrequencyMap.get(rightChar)-1);
                if(charFrequencyMap.get(rightChar) == 0 ){ // character is completely matched
                   matched++;
                }
            }
            if(matched == charFrequencyMap.size())
                return true;

            if(windowEnd >=pattern.length() -1) { //shrink the window by one character
                char leftChar = str.charAt(windowStart);
                if(charFrequencyMap.containsKey(leftChar)){
                    if(charFrequencyMap.get(leftChar) == 0)
                        matched--; //before putting the character back, decrement the matched count
                    //put the character back for matching
                    charFrequencyMap.put(leftChar,charFrequencyMap.get(leftChar)+1);
                }
                windowStart++; //move the window ahead
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("aaacb", "abc"));
    }

    }
