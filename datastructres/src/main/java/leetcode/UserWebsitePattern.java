package main.java.leetcode;

import java.util.*;

/*
1. save data in list and sort by time
2. save in user's sessions map
3. build every one's 3-subsequences list(set)
4. count 3-subsequences by map get maxCount
 */
public class UserWebsitePattern {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int len = timestamp.length;
        List<List<String>> sessions = new ArrayList<>();
        for(int i =0;i<len;i++){
            sessions.add(i,new ArrayList<>());
            sessions.get(i).add(username[i]);
            sessions.get(i).add(String.valueOf(timestamp[i]));
            sessions.get(i).add(website[i]);
        }
        sessions.sort((a,b)->Integer.parseInt(a.get(1))- Integer.parseInt(b.get(1)));
        Map<String,List<String>> usersMap = new HashMap<>();
        for(int i=0;i<len;i++){
            usersMap.putIfAbsent(sessions.get(i).get(0),new ArrayList<>());
            usersMap.get(sessions.get(i).get(0)).add(sessions.get(i).get(2));
        }
        Map<String,Integer> sequence = new HashMap<>();
        int maxCount = 0;
        String maxseq ="";
        for(String s:usersMap.keySet()){
            List<String> list = usersMap.get(s);
            Set<String> sequenceList = subsequence(list);
            for (String seq:sequenceList){
                sequence.put(seq,sequence.getOrDefault(seq,0)+1);
                if(sequence.get(seq)>maxCount){
                    maxCount = sequence.get(seq);
                    maxseq = seq;
                }
                else if(sequence.get(seq)==maxCount && seq.compareTo(maxseq)<0){
                    maxseq =seq; // Lexographical order
                }
            }

        }
        String[] strings = maxseq.split(",");
        List<String> ans = new ArrayList<String>(Arrays.asList(strings));
        return  ans;
    }

    public Set<String> subsequence(List<String> list){
        int n = list.size();
        Set<String> seq = new HashSet<>();
        for (int i = 0; i< n-2;i++){
            for (int j=i+1;j<n-1;j++){
                for (int k=j+1;k<n;k++){
                    seq.add(list.get(i)+","+list.get(j)+","+list.get(k));
                }
            }
        }
        return  seq;
    }

    }
