package main.java.topcodingquestion.arraysandstrings;

//https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String start = strs[0];
        for (int i = 1; i < strs.length; i++)

            while (strs[i].indexOf(start) != 0) {
                start = start.substring(0, start.length() - 1);
                if (start.isEmpty()) return "";
            }

        return start;
    }
}
