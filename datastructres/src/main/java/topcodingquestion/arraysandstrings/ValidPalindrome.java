package main.java.topcodingquestion.arraysandstrings;

// https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null)
            return true;
        int len = s.length();
        if (s != null && len == 0) return true;
        int low = 0;
        int high = len - 1;
        char head, tail;
        while (low <= high) {
            head = s.charAt(low);
            tail = s.charAt(high);
            if (!Character.isLetterOrDigit(head)) {
                low++;
            } else if (!Character.isLetterOrDigit(tail)) {
                high--;
            } else {
                if (Character.toLowerCase(head) != Character.toLowerCase(tail)) {
                    return false;
                }
                low++;
                high--;
            }
        }
        return true;
    }
}
