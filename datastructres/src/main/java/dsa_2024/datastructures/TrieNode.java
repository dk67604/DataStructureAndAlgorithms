package main.java.dsa_2024.datastructures;

public class TrieNode {
    private final int R = 26;
    private char key;
    private TrieNode[] links;
    boolean isEnd;

    public TrieNode(char key){
        this.links = new TrieNode[R];
        this.key = key;
    }

    public TrieNode[] getLinks(){
        return this.links;
    }

    public void setLinks(TrieNode[] links){
        this.links = links;
    }

    public boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }
    public TrieNode get(char ch){
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node){
        links[ch - 'a'] = node;
    }
    public boolean isEnd(){
        return this.isEnd;
    }
    public void setEnd(){
        this.isEnd = true;
    }

    public char getKey(){
        return this.key;
    }

    public void setKey(char ch){
        this.key = ch;
    }

}
