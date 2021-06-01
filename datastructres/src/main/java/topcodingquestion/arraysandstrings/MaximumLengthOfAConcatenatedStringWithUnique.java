package main.java.topcodingquestion.arraysandstrings;

import java.util.List;

public class MaximumLengthOfAConcatenatedStringWithUnique {
    private int result = 0;

    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) return 0;
        dfs(arr, "", 0);
        return result;
    }

    private void dfs(List<String> arr, String path, int idx) {
        boolean isUniquePath = isUnique(path);
        if (isUniquePath) {
            result = Math.max(result, path.length());
        }
        if (idx == arr.size() || !isUniquePath) {
            return;
        }
        for (int i = idx; i < arr.size(); i++) {
            dfs(arr, path + arr.get(i), i + 1);
        }
    }

    private boolean isUnique(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) != 0)
                return false;
            checker |= 1 << val;
        }
        return true;
    }
}
