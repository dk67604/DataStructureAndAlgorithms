package main.java.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {
    public static void main(String[] args) {
        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
        System.out.println(restoreIPAddresses.restoreIpAddresses("25525511135"));
    }

    public List<String> restoreIpAddresses(String s) {
        LinkedList<String> segments = new LinkedList<>();
        ArrayList<String> results = new ArrayList<>();
        int n = s.length();
        dfs(-1, 3, n, s, results, segments);
        return results;
    }

    private void dfs(int prev_pos, int dots, int n, String s, ArrayList<String> results, LinkedList<String> segments) {
        /*
    prev_pos : the position of the previously placed dot
    dots : number of dots to place
    */
        // The current dot curr_pos could be placed
        // in a range from prev_pos + 1 to prev_pos + 4.
        // The dot couldn't be placed
        // after the last character in the string.
        int maxPos = Math.min(n - 1, prev_pos + 4);
        for (int curr_pos = prev_pos + 1; curr_pos < maxPos; curr_pos++) {
            String segment = s.substring(prev_pos + 1, curr_pos + 1);
            if (isValid(segment)) {
                segments.add(segment); // place dot
                if (dots - 1 == 0) { //if all 3 dots are placed
                    /*
                    Append the current list of segments
                    to the list of solutions
                    */
                    String temp = s.substring(curr_pos + 1, n);
                    if (isValid(temp)) {
                        segments.add(temp);
                        results.add(String.join(".", segments));
                        segments.removeLast();//backtrack for other possibilities
                    }
                } else
                    dfs(curr_pos, dots - 1, n, s, results, segments);// continue to place dots
                segments.removeLast();// remove the last placed dot
            }
        }
    }

    private boolean isValid(String segment) {
           /*
            Check if the current segment is valid :
            1. less or equal to 255
            2. the first character could be '0'
            only if the segment is equal to '0'
            */
        int m = segment.length();
        if (m > 3) return false;
        return (segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : m == 1;
    }
}
