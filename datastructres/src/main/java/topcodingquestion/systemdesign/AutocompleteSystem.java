package main.java.topcodingquestion.systemdesign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SentenceNode{
    String sentence;
    int times;
    SentenceNode(String sentence, int times){
        this.sentence = sentence;
        this.times = times;
    }
}

class TrieNodeSen{
    int times;
    TrieNodeSen[] branches = new TrieNodeSen[27];
}

public class AutocompleteSystem{
    private TrieNodeSen root;
    private String curr_sent = "";

    public AutocompleteSystem(String[] sentences, int[] times){
        root = new TrieNodeSen();
        for(int i = 0; i< sentences.length;i++){
            insert(root, sentences[i],times[i]);
        }
    }

    public int charToInt(char c){
        return c == ' '?26: c - 'a';
    }

    public void insert(TrieNodeSen t, String s, int times){
        for(char c: s.toCharArray()){
            if(t.branches[charToInt(c)] == null) t.branches[charToInt(c)] = new TrieNodeSen();
            t = t.branches[charToInt(c)];
        }
        t.times += times;
    }

    private List<SentenceNode> lookup(TrieNodeSen t, String s){
        List<SentenceNode> list = new ArrayList<>();
        for(char c: s.toCharArray()){
            if(t.branches[charToInt(c)] == null){
                return new ArrayList<>();
            }
            t = t.branches[charToInt(c)];
        }
        traverse(s,t,list);
        return list;
    }

    public void traverse(String s, TrieNodeSen t, List<SentenceNode> list){
        if(t.times > 0) list.add(new SentenceNode(s,t.times));
        for(char i = 'a'; i<='z';i++){
            if(t.branches[i-'a'] != null){
                traverse(s + i,t.branches[i-'a'],list);
            }
        }
        if(t.branches[26] != null){
            traverse(s + ' ',t.branches[26],list);
        }
    }

    public List<String> input(char c){
        List<String> res = new ArrayList<>();
        if(c == '#'){
            insert(root,curr_sent,1);
            curr_sent = "";
        }else{
            curr_sent +=c;
            List<SentenceNode> list = lookup(root,curr_sent);
            Collections.sort(list,(a, b) -> a.times == b.times?a.sentence.compareTo(b.sentence):b.times - a.times);
            for(int i =0 ; i<Math.min(3,list.size());i++){
                res.add(list.get(i).sentence);
            }
        }
        return res;
    }
}