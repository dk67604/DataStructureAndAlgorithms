package main.java.leetcode;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map =new HashMap<>();
        List<String> ans =new ArrayList<String>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> pq =new PriorityQueue<>(
                (a,b)-> a.getValue() == b.getValue()?a.getKey().compareTo(b.getKey()):a.getValue()-b.getValue());

        for(Map.Entry<String,Integer>entry:map.entrySet()){
            pq.offer(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            Map.Entry<String,Integer> entry=pq.poll();
            ans.add(0,entry.getKey());
        }
        return ans;
    }
}
