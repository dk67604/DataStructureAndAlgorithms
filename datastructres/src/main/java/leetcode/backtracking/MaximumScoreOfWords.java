package main.java.leetcode.backtracking;

public class MaximumScoreOfWords {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[score.length];
        for(char ch:letters){
            freq[ch-'a']++;
        }
        int idx = 0;
        return backtrack(words,freq,score,idx);
    }
    private int backtrack(String[] words,int[] freq, int[] scores, int idx){
       int max = 0;
       for(int i =idx; i< words.length; i++){
           int res =0;
           boolean isValid = true;
           for (char ch: words[i].toCharArray()){
               freq[ch - 'a']--;
               res += scores[ch - 'a'];
               if (freq[ch - 'a'] < 0)
                   isValid = false;
           }
           if(isValid){
               res += backtrack(words,freq,scores,i+1);
               max = Math.max(res,max);
           }
           //backtrack
           for (char ch : words[i].toCharArray()){
               freq[ch - 'a']++;
               res =0;
           }
       }
        return max;

    }
}

