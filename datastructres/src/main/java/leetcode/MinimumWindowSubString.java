package main.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {

    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        // Track the count of unique characters in String T
        Map<Character,Integer> map=new HashMap<>();
        for(char c:t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int counter=map.size();//Track the size of required window which has all the unique characters in T
        int right=0,left=0;// Left pointer which contract to find the smallest
        // window and right pointer expands until all characters found from T exist in S
        int start=0;// After finding the current  minimum window keep track of new left
        int len=Integer.MAX_VALUE; // Minimum Window Substring Length
        while(right<s.length()){
            char c=s.charAt(right); // retrieve from right
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0) counter--;
            }
            right++; // Expand the right side of the window
            while(counter==0){ //Compress the left side of the window till the valid condition
                char tempc=s.charAt(left);
                if(map.containsKey(tempc)){
                    map.put(tempc,map.get(tempc)+1);//Update the unique character count
                    if(map.get(tempc)>0){
                        counter++;//Increase the counter to invalidate the condition
                    }
                }
                if(right-left <len){
                    len=right-left;
                    start=left;
                }
                left++;
            }

        }
        if(len==Integer.MAX_VALUE)return "";
        return s.substring(start,start+len);
    }

    public static void main(String[] args) {
        String S="ADOBECODEBANC";
        String T="ABC";
        MinimumWindowSubString minimumWindowSubString=new MinimumWindowSubString();
        System.out.println(minimumWindowSubString.minWindow(S,T));

    }
}
