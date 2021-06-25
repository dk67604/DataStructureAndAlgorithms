package main.java.topcodingquestion.systemdesign;

import java.util.*;

class User {
    String username;
    int timestamp;
    String website;

    public User(String username, int timestamp, String website) {
        this.username = username;
        this.timestamp = timestamp;
        this.website = website;
    }
}//https://leetcode.com/problems/analyze-user-website-visit-pattern/

public class AnalyzeUserWebsiteVisitPattern {

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<User> users = new ArrayList<>();
        int len = timestamp.length;
        for (int i = 0; i < len; i++) {
            users.add(new User(username[i], timestamp[i], website[i]));
        }
        PriorityQueue<User> minHeap = new PriorityQueue<>((a, b) -> a.timestamp - b.timestamp);
        minHeap.addAll(users);
        Map<String, List<String>> userMap = new HashMap<>();
        while (!minHeap.isEmpty()) {
            User user = minHeap.poll();
            userMap.putIfAbsent(user.username, new ArrayList<>());
            userMap.get(user.username).add(user.website);
        }
        Map<String, Integer> sequence = new HashMap<>();
        int maxCount = 0;
        String maxSeq = "";
        for (String user : userMap.keySet()) {
            List<String> websites = userMap.get(user);
            Set<String> sequencesList = subsequence(websites);
            for (String seq : sequencesList) {
                sequence.put(seq, sequence.getOrDefault(seq, 0) + 1);
                if (sequence.get(seq) > maxCount) {
                    maxCount = sequence.get(seq);
                    maxSeq = seq;
                } else if (sequence.get(seq) == maxCount && seq.compareTo(maxSeq) < 0) {
                    maxSeq = seq;
                }
            }
        }
        String[] tuples = maxSeq.split(",");
        List<String> ans = new ArrayList<>(Arrays.asList(tuples));
        return ans;
    }

    private Set<String> subsequence(List<String> websites) {
        Set<String> subsequences = new HashSet<>();
        int n = websites.size();
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    subsequences.add(websites.get(i) + "," + websites.get(j) + "," + websites.get(k));
                }
            }
        }
        return subsequences;
    }
}
