package main.java.leetcode.trieproblems;



class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root=new TrieNode('/');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
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

    //Search the given word in Trie
    private TrieNode searchPrefix(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++) {
            char currentChar=word.charAt(i);
            if(node.containsKey(currentChar)) {
                node=node.get(currentChar);
            }else {
                return null;
            }

        }
        return node;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node!=null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node !=null;
    }
}