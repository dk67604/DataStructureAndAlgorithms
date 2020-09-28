package educative.io.coding.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
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
                resultIndices.add(windowStart);

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
        return resultIndices;
    }
    public static void main(String[] args) {
        System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
        System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
    }
}
