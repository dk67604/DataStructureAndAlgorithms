package main.java.dsa_2024.datastructures;

public class Trie {

    private TrieNode root;

    public Trie(){
        this.root = new TrieNode('/');
    }
    /*
     * Inserts a word into the Trie
     */

     public void insert(String word){
        TrieNode trieNode = root;
        int len = word.length();
        for(int i =0; i< len; i++){
            char c = word.charAt(i);
            if (!trieNode.containsKey(c)){
                trieNode.put(c, new TrieNode(c));
            }
            trieNode = trieNode.get(c);
        }
        trieNode.setEnd();
     }
      /*
       * Search the given word
       */
      public TrieNode searchPrefix(String word){
        TrieNode trieNode = root;
        for(int i =0; i< word.length(); i++){
            char currentChar = word.charAt(i);
            if (trieNode.containsKey(currentChar)){
                trieNode = trieNode.get(currentChar);
            }else{
                return null;
            }
        }
        return trieNode;
      }

      /*
       * Return if word is present in trie
       */

       public boolean search(String word){
            TrieNode trieNode = this.searchPrefix(word);
            return trieNode != null && trieNode.isEnd();
       }

       /*
        * Return if there is any word in trie that starts with the given prefix
        */
        public boolean startsWith(String prefix){
            TrieNode trieNode = this.searchPrefix(prefix);
            return trieNode != null;
        }

        public static void main(String[] args) {
            Trie trie = new Trie();
            trie.insert("apple");
            trie.insert("orange");
            trie.insert("banana");
            trie.insert("apricot");
            System.out.println(trie.startsWith("ap"));
            System.out.println(trie.searchPrefix("grapes"));
            System.out.println(trie.search("orange"));
        }
}
