package main.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer> counts=new HashMap<>(); // Map store the occurrences of the word in words array
        List<Integer> indexes=new ArrayList<>(); //Store the indexes of starting matching substring exist in words array


        int n=s.length();
        int num=words.length;
        if(n<=0 || num<=0){
            return indexes;
        }
        int len=words[0].length();//size of word
        int totalCharsize=len*num;
        if(totalCharsize>n){
            return indexes;
        }
        for(int i=0;i<num;i++){
            counts.put(words[i],counts.getOrDefault(words[i],0)+1);
        }
        //Run the loop till n-num*len+1 which is equivalent to size of all the characters in words array,
        // Consider this case
        //a) s.length = 10 -->(0-9 indexes) and
        //b) given words[] = {"aa", "aa", "aa"}....
        //c) The total length of substring is (3 words * 2 char len each) = 6.
        //
        //So when searching for subString in 's' the window should contain at least 6 chars.
        //So possible start positions of subString in 's' are 0,1,2,3,4 only. From 5th position, there are only 5 chars or less to search...
        //So no point searching sections of 's' which have insufficient number of chars to required to find the subString
        //+1 is required because array indexes start from 0 and not 1... an array of length 5 has index 0-4
        for(int i=0;i<n-num*len+1;i++){
            Map<String,Integer> seen=new HashMap<>();//Store substring indexes seen while forming the substring from String s
            int j=0;
            while (j<num){//run a loop for each word present in word array
                String word=s.substring(i+j*len,i+(j+1)*len);
                if(counts.containsKey(word)){
                  seen.put(word,seen.getOrDefault(word,0)+1);
                  if(seen.get(word)>counts.get(word)){ //check the condition if occurrences exceeds the word count in array than break
                      break;
                  }
                }else {
                    break;
                }
                j++;

            }
            if(j==num){
                indexes.add(i);
            }

        }
        return indexes;
    }
}
