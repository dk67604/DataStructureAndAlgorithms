package main.java.leetcode.trieproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Trie__{
    Trie__ [] tries;
    LinkedList<String> suggestions;
    public Trie__(){
        this.tries = new Trie__[26];
        this.suggestions = new LinkedList<>();
    }

}

public class SearchSuggestionSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        Arrays.sort(products); //sort the product to build Trie
        Trie__ root =new Trie__();
        for(String p: products){
            Trie__ t = root;
            for(char c:p.toCharArray()){
                if(t.tries[c-'a'] == null) t.tries[c -'a'] = new  Trie__();
                t=t.tries[c-'a'];
                if (t.suggestions.size()<3){
                    t.suggestions.offer(p); // Maintains 3 word lexographically and put the word
                                            // with the same prefix in the same list
                }
            }
        }
        for (char c: searchWord.toCharArray()){
            if(root!=null) {
                root = root.tries[c - 'a'];
            }
                if(root!=null){
                    ans.add(root.suggestions);
                }
                else {
                    ans.add(Arrays.asList());
                }

        }
       return ans;

    }
}
