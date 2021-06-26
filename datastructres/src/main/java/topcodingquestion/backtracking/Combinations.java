package main.java.topcodingquestion.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new LinkedList<Integer>(), n, k, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, LinkedList<Integer> current, int n, int k, int first) {
        if (current.size() == k) {
            result.add(new LinkedList<>(current));
            return;
        }
        for (int i = first; i < n + 1; i++) {
            current.add(i);
            backtrack(result, current, n, k, i + 1);
            current.removeLast();
        }
    }
}
