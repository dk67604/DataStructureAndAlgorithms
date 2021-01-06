package main.java.arraysstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CustomSort {
    public String customSortString(String S, String T) {
        char[] schar = S.toCharArray();
        char[] tchar = T.toCharArray();
        int[] count = new int[26];
        // Create a array that represents a character occurrences in T
        for(char c:tchar){
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        // loop through S and the character in same order to the result
        for(char c : schar){
            for(int j = 0;j<count[c - 'a'];++j){
                sb.append(c);
            }
            count[c - 'a'] =0;
        }
        //Run this loop to add remaining character in T
        for(char c='a'; c<='z';++c){
            for (int i = 0; i < count[c-'a'];++i)
                sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String S = "cba";
        String T = "abccd";
        CustomSort customSort = new CustomSort();
        System.out.println(customSort.customSortString(S,T));
    }
}
