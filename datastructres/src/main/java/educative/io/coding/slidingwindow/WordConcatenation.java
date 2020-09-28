package main.java.educative.io.coding.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string and a list of words, find all the starting indices of substrings in the given
 * string that are a concatenation of all the given words exactly once without any overlapping of words.
 * It is given that all words are of the same length.
 */
public class WordConcatenation {
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<>();
        Map<String,Integer> wordFrequencyMap = new HashMap<>();
        for(String word : words){
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0)+1);
        }
        int wordsCount = words.length, wordLength = words[0].length();
        //Run the loop till str.length() - wordsCount * wordLength which is equivalent to size of all the characters in words array,
        // Consider this case
        //a) str.length = 10 -->(0-9 indexes) and
        //b) given words[] = {"aa", "aa", "aa"}....
        //c) The total length of substring is (3 words * 2 char len each) = 6.
        //
        //So when searching for subString in 's' the window should contain at least 6 chars.
        //So possible start positions of subString in 's' are 0,1,2,3,4 only. From 5th position, there are only 5 chars or less to search...
        //So no point searching sections of 's' which have insufficient number of chars to required to find the subString
        //+1 is required because array indexes start from 0 and not 1... an array of length 5 has index 0-4
        for(int i = 0; i<= str.length() - wordsCount*wordLength ;i++){
            Map<String,Integer> wordSeen = new HashMap<>();
            for(int j = 0;j < wordsCount;j++){
                int nextWordIndex = i+ j * wordLength;
                //get the next word from the string
                String word = str.substring(nextWordIndex,nextWordIndex + wordLength);
                if(!wordFrequencyMap.containsKey(word)) //break if we don't need this word
                    break;
                wordSeen.put(word, wordSeen.getOrDefault(word,0)+1);
                // no need to process further if the word has higher frequency than required
                if(wordSeen.get(word) > wordFrequencyMap.getOrDefault(word,0))
                    break;

                if(j+1 == wordsCount){//store the index if we have found all the words
                    resultIndices.add(i);
                }
            }
        }
        return resultIndices;

    }
    public static void main(String[] args) {
        List<Integer> result = WordConcatenation.findWordConcatenation("catfoxcat", new String[] { "cat", "fox" });
        System.out.println(result);
        result = WordConcatenation.findWordConcatenation("catcatfoxfox", new String[] { "cat", "fox" });
        System.out.println(result);
    }


    }
