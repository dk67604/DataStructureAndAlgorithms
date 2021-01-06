package main.java.leetcode.trieproblems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class TrieNode_{
    Map<Character,TrieNode_> children = new HashMap<>();
    boolean isWord;

}
public class StreamChecker {
    TrieNode_ trieNode_ = new TrieNode_();
    Deque<Character> stream = new ArrayDeque<>();

    public StreamChecker(String[] words) {
        for(String word : words){
            TrieNode_ node = trieNode_;
            String reversedWord = new StringBuilder(word).reverse().toString();
            for(Character ch : reversedWord.toCharArray()){
                if(!node.children.containsKey(ch)){
                    node.children.put(ch,new TrieNode_());
                }
                node = node.children.get(ch);
            }

            node.isWord = true;
        }
    }
    public boolean query(char letter) {
        stream.addFirst(letter);
        TrieNode_ node_ = trieNode_;
        for (char ch : stream){
            if(node_.isWord){
                return true;
            }
            if(!node_.children.containsKey(ch)) return false;
            node_ = node_.children.get(ch);
        }

        return node_.isWord;
    }

}
