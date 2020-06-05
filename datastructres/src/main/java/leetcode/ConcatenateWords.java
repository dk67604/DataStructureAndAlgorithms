package main.java.leetcode;

import java.util.*;

public class ConcatenateWords {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> preWords = new HashSet<>();
        List<String> res = new ArrayList<>();
        Arrays.sort(words,(s1,s2)->s1.compareTo(s2));
        for(int i =0;i<words.length;i++){
            if(!preWords.isEmpty()&& wordBreakDp(words[i],preWords)){
                res.add(words[i]);
            }
            preWords.add(words[i]);
        }
        return res;
    }

    public boolean wordBreakDp(String s , Set<String> wordDict){
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1 ;i<=s.length();i++){
            for (int j = 0;j<i;j++){
                String sb = s.substring(j,i);
                if(dp[j] && wordDict.contains(sb)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
