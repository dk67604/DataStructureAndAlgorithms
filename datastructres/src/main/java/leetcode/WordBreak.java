package main.java.leetcode;

import java.util.*;

public class WordBreak {

    //BFS approach, queue contains the index which represents the before end there is a match of word
    // in dictionary
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        Queue<Integer> queue=new LinkedList<>();
        int[] visited=new int[s.length()];
        queue.add(0);
        while(!queue.isEmpty()){
            int start=queue.remove();
            if(visited[start]==0){
                for(int end=start+1;end<=s.length();end++){
                    if(set.contains(s.substring(start,end))){
                        queue.add(end);
                        if(end==s.length()){
                            return true;
                        }
                    }
                }
                visited[start]=1;
            }
        }
        return false;
    }

    //Using Dynamic Programing

    /* Reference : https://leetcode.com/problems/word-break/solution/
    Now, we'll move onto the process of \text{dp}dp array formation. We make use of \text{dp}dp array of size n+1n+1, where nn is the length of the given string. We also use two index pointers ii and jj, where ii refers to the length of the substring (s's
′
 ) considered currently starting from the beginning, and jj refers to the index partitioning the current substring (s's
′
 ) into smaller substrings s'(0,j)s
′
 (0,j) and s'(j+1,i)s
′
 (j+1,i). To fill in the \text{dp}dp array, we initialize the element \text{dp}[0]dp[0] as \text{true}true, since the null string is always present in the dictionary, and the rest of the elements of \text{dp}dp as \text{false}false. We consider substrings of all possible lengths starting from the beginning by making use of index ii. For every such substring, we partition the string into two further substrings s1's1
′
  and s2's2
′
  in all possible ways using the index jj (Note that the ii now refers to the ending index of s2's2
′
 ). Now, to fill in the entry \text{dp}[i]dp[i], we check if the \text{dp}[j]dp[j] contains \text{true}true, i.e. if the substring s1's1
′
  fulfills the required criteria. If so, we further check if s2's2
′
  is present in the dictionary. If both the strings fulfill the criteria, we make \text{dp}[i]dp[i] as \text{true}true, otherwise as \text{false}false.

     */

    public boolean wordBreakDp(String s , List<String> wordDict){
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1 ;i<=s.length();i++){
            for (int j = 0;j<i;j++){
                String sb = s.substring(j,i);
                if(dp[j] && wordDictSet.contains(sb)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        String s = "leetcode";
        String[] words ={"leet", "code"};
        System.out.println(wordBreak.wordBreak(s,Arrays.asList(words)));
        System.out.println(wordBreak.wordBreakDp(s,Arrays.asList(words)));
    }
}
