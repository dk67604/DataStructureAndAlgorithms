package main.java.leetcode.trieproblems;

import java.util.ArrayList;
import java.util.List;



public class WordSearchII {
    class TrieNode{
        TrieNode [] links = new TrieNode[26];
        String word;
    }


    public List<String> findWords(char[][] board, String[] words) {
            List<String> res = new ArrayList<>();
            TrieNode root = buildTrie(words);
            for (int i = 0;i<board.length;i++){
                for (int j=0;j<board[0].length;j++){
                    dfs(root,res,board,i,j);
                }
            }
            return res;
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for (String w:words){
            TrieNode p =root;
            for (char c:w.toCharArray()){
                if(p.links[c-'a'] ==null)p.links[c-'a'] = new TrieNode();
                p = p.links[c-'a'];
            }
            p.word=w;
        }
        return root;

    }

    private void dfs(TrieNode p,List<String> res,char[][] board,int i, int j){
        char c = board[i][j];
        if(c== '#' || p.links[c-'a'] == null) return;
        p = p.links[c-'a'];
        if(p.word!=null) //Found one
        {
            res.add(p.word);
            p.word =null; //Avoid duplicate in result
        }
        board[i][j] = '#'; //Visited
        if(i>0) dfs(p,res,board,i-1,j);
        if(j>0) dfs(p,res,board,i,j-1);
        if(i<board.length-1) dfs(p,res,board,i+1,j);
        if(j<board[0].length-1) dfs(p,res,board,i,j+1);
        board[i][j] = c; //Restore c to form the another possible word
        // Optimization: incrementally remove the leaf nodes
        if(p.links.length == 0) p.links[c - 'a'] = null;
    }
}
