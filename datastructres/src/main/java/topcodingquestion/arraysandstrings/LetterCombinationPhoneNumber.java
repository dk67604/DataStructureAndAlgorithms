package main.java.topcodingquestion.arraysandstrings;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationPhoneNumber {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.length() == 0) ;
        ans.add("");
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        while (ans.peek().length() != digits.length()) {
            String remove = ans.remove();
            String map = mapping[digits.charAt(remove.length()) - '0'];
            for (char c : map.toCharArray()) {
                ans.add(remove + c);
            }
        }
        return ans;
    }
}
