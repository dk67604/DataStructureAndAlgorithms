package main.java.arraysstrings;

import java.util.*;
/*
if we found a pair like s-{a,b} t-{b,a} swapping will increase match by 2.
if we found a pair like s-{a,t} t-{t,b} swapping will increase match by 1.
if any repeated character in s or pair like s-{a,b} t-{c,d} then swapping will not change matching count.
now we will change already matched pair so swapping will decrease matching by 2 but cant be negative.
 */
public class MatchingPairs {
    int matchingPairs(String s, String t) {
        Set<Character> countSet = new HashSet<>();
        Set<Character> misMatchSetS = new HashSet<>();
        Set<Character> misMatchSetT = new HashSet<>();
        boolean isRepeated = false;
        int matching =0;
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if(ch1!=ch2){
                set.add(ch1+""+ch2);
                misMatchSetS.add(ch1);
                misMatchSetT.add(ch2);
            }
            else
                matching++;

            if(!isRepeated){
                if(countSet.contains(ch1)){
                    isRepeated = true;
                }
                else{
                    countSet.add(ch1);
                }
            }
        }

        for(String pair: set){
            String reverse = pair.charAt(1)+""+pair.charAt(0);
            if(set.contains(reverse)){
                return matching+2;
            }
        }
        for(Character ch:misMatchSetS){
            if(misMatchSetT.contains(ch))
                return matching + 1;
        }
        if(isRepeated||set.size()>=2)
            return matching;

        return matching <= 2 ?0 :matching-2;
    }

    public static void main(String[] args) {
        String s = "abcde";
        String t = "adcex";
        MatchingPairs matchingPairs = new MatchingPairs();
        System.out.println(matchingPairs.matchingPairs(s,t));
    }
}
