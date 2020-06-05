package main.java.leetcode;

public class TrieNode {
  private char key;
  private TrieNode[] links;
  public TrieNode[] getLinks() {
	return links;
}
public void setLinks(TrieNode[] links) {
	this.links = links;
}
private final int R=26;
  private boolean isEnd;
  public TrieNode(char key) {
	  links=new TrieNode[R];
	  this.key=key;
  }
  public boolean containsKey(char ch) {
	  return links[ch-'a']!=null;
  }
  public TrieNode get(char ch) {
	  return links[ch-'a'];
  }
  public void put(char ch,TrieNode node) {
	  links[ch-'a']=node;
  }
  public void setEnd() {
	  isEnd=true;
  }
  public boolean isEnd() {
	  return isEnd;
  }
 public char getKey() {
	return key;
}
public void setKey(char key) {
	this.key = key;
}
  
  
}
