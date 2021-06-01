package main.java.topcodingquestion.arraysandstrings;

public class ValidStringParentheses {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;// keep track of lowest and highest open bracket
        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == '*') {
                --low;
                high++;
            } else {
                low--;
                high--;
                if (high < 0) return false;
            }
            if (low < 0) low = 0;
        }
        return low == 0;
    }
}
