package main.java.topcodingquestion.arraysandstrings;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();

        words.remove(beginWord);
        queue.add(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int k = 0; k < size; k++) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) return level;
                List<String> neighbors = neighbors(currentWord);
                for (String neighbor : neighbors) {
                    if (words.contains(neighbor)) {
                        queue.add(neighbor);
                        words.remove(neighbor);
                    }
                }
            }
        }
        return 0;

    }

    private List<String> neighbors(String s) {
        char[] chars = s.toCharArray();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                result.add(new String(chars));
            }
            chars[i] = temp;
        }
        return result;
    }
}
