package main.java.topcodingquestion.arraysandstrings;

//https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
public class ReplaceAllToAvoidConsecutiveLetter {
    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                // Replace the current '?' with 'a', 'b', or 'c'.
                for (char curr = 'a'; curr <= 'c'; curr++) {
                    boolean prevUnequal = (i - 1 == -1 || chars[i - 1] != curr);
                    boolean nextUnequal = (i + 1 == chars.length || chars[i + 1] != curr);
                    if (prevUnequal && nextUnequal)
                        chars[i] = curr;
                }

            }
        }
        return new String(chars);
    }
}
