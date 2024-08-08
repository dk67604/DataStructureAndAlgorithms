package main.java.dsa_2024.algorithms.backtracking;

import java.util.*;

class TrieNode {
    public TrieNode[] links = new TrieNode[26];
    String word;
}
public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words){
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i =0; i< board.length; i++){
            for(int j =0; j< board[0].length; j++){
                dfs(root, res, board, i, j);
            }
        }
        return res;
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for (String word: words){
            TrieNode p = root;
            for (char c: word.toCharArray()){
                if(p.links[c - 'a'] == null) p.links[c - 'a'] = new TrieNode();
                p = p.links[c - 'a'];
            }
            p.word = word;
        }
        return root;
    }

    private void dfs(TrieNode p, List<String> res, char[][] board, int i, int j){
        if(i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == '#'){
            return;
        }
        char c = board[i][j];
        if(c == '#' || p.links[c - 'a'] == null) return;
        p = p.links[c - 'a'];
        if(p.word != null){
            res.add(p.word);
            p.word = null;
        }
        board[i][j] = '#';
        dfs(p, res, board, i+1, j);
        dfs(p, res, board, i-1, j);
        dfs(p, res, board, i, j+1);
        dfs(p, res, board, i, j-1);
        board[i][j] = c;
        if (p.links.length == 0) p.links[c - 'a'] = null;
    }

}
