package main.java.leetcode;

import java.util.*;

public class TopKFrequentlyWords {

    private static List<String> solve(int k, String[] keywords, String[] reviews) {
        List<String> ans =new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        Set<String> unique = new HashSet<String>(Arrays.asList(keywords));
        for(String s:reviews){
            s = s.toLowerCase();
            Set<String> added =new HashSet<>();
            String[] tokens = s.split("\\W");
            for(String r:tokens){
                if(unique.contains(r) && !added.contains(r)){
                    map.put(r,map.getOrDefault(r,0)+1);
                    added.add(r);
                }
            }
        }

        PriorityQueue<Map.Entry<String,Integer>> pq =new PriorityQueue<>((a,b)-> a.getValue()==b.getValue()
        ?a.getKey().compareTo(b.getKey()):b.getValue()-a.getValue());
        pq.addAll(map.entrySet());
        while (!pq.isEmpty() && k>0){
            ans.add(pq.poll().getKey());
            k--;
        }
        return ans;
    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public ArrayList<String> topNCompetitors(int numCompetitors,
                                             int topNCompetitors,
                                             List<String> competitors,
                                             int numReviews,
                                             List<String> reviews)
    {
        // WRITE YOUR CODE HERE
        ArrayList<String> ans =new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        Set<String> unique = new HashSet<String>(competitors);
        for(String s:reviews){
            s = s.toLowerCase();
            Set<String> added =new HashSet<>();
            String[] tokens = s.split("\\W");
            for(String r:tokens){
                if(unique.contains(r) && !added.contains(r)){
                    map.put(r,map.getOrDefault(r,0)+1);
                    added.add(r);
                }
            }
        }

        PriorityQueue<Map.Entry<String,Integer>> pq =new PriorityQueue<>((a,b)-> a.getValue()==b.getValue()
                ?a.getKey().compareTo(b.getKey()):b.getValue()-a.getValue());
        pq.addAll(map.entrySet());

        if(topNCompetitors>unique.size()){

        }
        while (!pq.isEmpty() && topNCompetitors>0){
            ans.add(pq.poll().getKey());
            topNCompetitors--;
        }

        return ans;
    }

    private static class keyValue {
        int val;
        String key;

        keyValue(int v, String k) {
            this.val = v;
            this.key = k;
        }
    }
    public static void main(String[] args) {
        int k1 = 2;
        String[] keywords1 = { "anacell", "cetracular", "betacellular" };
        String[] reviews1 = { "Anacell provides the best services in the city", "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell", };
        int k2 = 2;
        String[] keywords2 = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
        String[] reviews2 = { "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services", "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell", "Betacellular is better than deltacellular.", };
        System.out.println(solve(k1, keywords1, reviews1));
        System.out.println(solve(k2, keywords2, reviews2));
    }
}

