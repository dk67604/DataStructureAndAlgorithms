package main.java.leetcode.backtracking;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class CombinationIterator {
    Queue<String> queue;
    public CombinationIterator(String characters, int combinationLength) {
        queue = new LinkedList<>();
        generate(characters,0, "",combinationLength,queue);
    }
    private void generate(String characters, int start, String sofar,int k, Queue<String> queue){
        if( k==0){
            queue.add(sofar);
            return;
        }
        for(int i =start; i< characters.length();i++){
            generate(characters,i+1,sofar + characters.charAt(i),k-1,queue);
        }
    }

    public String next() {
       return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

}
