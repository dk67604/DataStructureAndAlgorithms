package main.java.topcodingquestion.arraysandstrings;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
A string s is called good if there are no two different characters in s that have the same frequency.

Given a string s, return the minimum number of characters you need to delete to make s good.

The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
 */
public class MinimumDeletionToMakeStringGood {
    public int minDeletions(String s) {
        int[] cnt = new int[26];
        int res = 0;
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < s.length(); i++)
            ++cnt[s.charAt(i) - 'a'];
        for (int i = 0; i < 26; i++) {
            while (cnt[i] > 0 && !used.add(cnt[i])) {
                --cnt[i];
                ++res;
            }
        }
        return res;
    }
}
