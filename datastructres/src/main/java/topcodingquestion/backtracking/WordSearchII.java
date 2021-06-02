package main.java.topcodingquestion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(root, res, board, i, j);
            }
        }
        return res;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                if (p.links[c - 'a'] == null) p.links[c - 'a'] = new TrieNode();
                p = p.links[c - 'a'];
            }
            p.word = word;
        }
        return root;
    }

    private void dfs(TrieNode p, List<String> res, char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == '#')
            return;
        char c = board[i][j];
        if (c == '#' || p.links[c - 'a'] == null) return;
        p = p.links[c - 'a'];
        if (p.word != null) { //Found one
            res.add(p.word);
            p.word = null; //Avoid duplicate in result
        }
        board[i][j] = '#';//visited
        if (i > 0) dfs(p, res, board, i - 1, j);//up
        if (j > 0) dfs(p, res, board, i, j - 1);//left
        if (i < board.length - 1) dfs(p, res, board, i + 1, j); //up
        if (j < board[0].length - 1) dfs(p, res, board, i, j + 1);//right
        board[i][j] = c;//Restore c to form the another possible word
        if (p.links.length == 0) p.links[c - 'a'] = null;
    }

    class TrieNode {
        TrieNode[] links = new TrieNode[26];
        String word;
    }
}
