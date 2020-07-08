package main.java.leetcode;

import java.util.ArrayList;
import java.util.List;

 class Trie_ {
   private TrieNode root;
   public Trie_() {
	   
	   this.root=new TrieNode('/');
   }
   
   //Insert new word in Trie data structure
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
	   public TrieNode searchPrefix(String word) {
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
   
   public List<String> getWords(String prefix){
	   List<String> wordsList=new ArrayList<>();
	   TrieNode node=searchPrefix(prefix);
	   if(node!=null) {
		   if(node.isEnd())wordsList.add(prefix);
		   getWordRecurse(prefix, node, wordsList);
	   }
	   return wordsList;
   }
   
   public void getWordRecurse(String prefix,TrieNode node,List<String> wordsList) {
	   for(TrieNode n:node.getLinks()) {
		   if(n!=null) {
		   String nodeString=prefix+String.valueOf(n.getKey());
		   if(n.isEnd()) {wordsList.add(nodeString);//if end of word reached return to previous stack
		    return;
		   }
		   if(n.getLinks().length>0)getWordRecurse(nodeString, n, wordsList);
		   }
	   }
   }
   
   public static void main(String[] args) {
   	Trie_ trie=new Trie_();
	trie.insert("cold");
	trie.insert("cough");
	trie.insert("fever");
	trie.insert("feverish");


	List<String> words=trie.getWords("co");
	for(String s:words) {
		System.out.println(s);
	}
}
}
