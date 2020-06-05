package main.java.leetcode.trieproblems;

import main.java.leetcode.trieproblems.TrieNode;

public class WordDictionary {

    private TrieNode root;
    public WordDictionary(){
        root = new TrieNode('/');
    }

    /** Inserts a word into the trie. */
    public void addWord(String word) {
        TrieNode node=root;
        int len=word.length();
        for(int i=0;i<len;i++) {
            char c=word.charAt(i);
            if(!node.containsKey(c)) {
                node.put(c, new TrieNode(c));
            }
            node=node.get(c);
        }
        node.setEnd();
    }


    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word){
        return helper(word.toCharArray(),0,root);
    }

    private boolean helper(char[] chars,int k, TrieNode node){
        //Base condition
        if(k == chars.length){
            return node.isEnd();
        }
        if(chars[k] == '.'){
            for (int i = 0; i< node.getLinks().length;i++){
                if(node.getLinks()[i]!=null && helper(chars,k+1,node.getLinks()[i]))
                    return true;
            }

        }
        else {
            return node.getLinks()[chars[k] -'a']!=null && helper(chars,
                    k+1,node.getLinks()[chars[k]-'a']);
        }
        return false;
    }
}
