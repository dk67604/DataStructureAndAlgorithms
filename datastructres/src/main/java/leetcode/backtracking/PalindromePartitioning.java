package main.java.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(s, 0, result, new ArrayList<String>());
        return result;

    }

    private void dfs(String s, int start, List<List<String>> result, List<String> currentList) {
        if (start >= s.length()) result.add(new ArrayList<>(currentList));
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                currentList.add(s.substring(start, end));
                dfs(s, end + 1, result, currentList);
            }
            currentList.remove(currentList.size() - 1);
        }

    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;

        }
        return true;
    }
}
