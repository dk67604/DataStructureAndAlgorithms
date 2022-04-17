package main.java.lc_2020;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 * Solution: Two- Pointer approach
 *
 *
 * Example 1:
 *
 * Input: s = "aba"
 * Output: true
 * Example 2:
 *
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 * Example 3:
 *
 * Input: s = "abc"
 * Output: false
 */
public class LC680 {
    public boolean validPalindrome(String s) {
        int i =0;
        int j = s.length() -1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return (checkPalindrome(s, i,j-1) || checkPalindrome(s,i+1,j));
            }
            i++;
            j--;
        }
        return true;

    }
    private boolean checkPalindrome(String s, int i , int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
