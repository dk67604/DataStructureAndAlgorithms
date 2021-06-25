package main.java.topcodingquestion.stacks;

public class MaximumDepthOfValidParentheses {

    public int maxDepth(String s) {
        int maxDepth = 0, depth = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                maxDepth = Math.max(maxDepth, ++depth);
            }
            if (ch == ')')
                depth--;
        }
        return maxDepth;
    }
}
