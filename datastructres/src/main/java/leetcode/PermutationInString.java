package main.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if(s1==null || s2==null) return false;
        if(s1.length()>s2.length()) return false;
        // Track the count of unique characters in String T
        Map<Character,Integer> map=new HashMap<>();
        for(char c:s1.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int counter=map.size();//Track the size of required window which has all the unique characters in T
        int right=0,left=0;// Left pointer which contract to find the smallest
        // window and right pointer expands until all characters found from T exist in S
        int start=0;// After finding the current  minimum window keep track of new left
        int len=s1.length(); // Minimum Window Substring Length
        while(right<s2.length()){
            char c=s2.charAt(right); // retrieve from right
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0) counter--;
            }

            while(counter==0){ //Compress the left side of the window till the valid condition
                if(right - left + 1 == len) {
                    return true;
                }
                char tempc=s2.charAt(left);
                if(map.containsKey(tempc)){
                    map.put(tempc,map.get(tempc)+1);//Update the unique character count
                    if(map.get(tempc)>0){
                        counter++;//Increase the counter to invalidate the condition
                    }
                }

                left++;
            }
            right++; // Expand the right side of the window
        }
      return false;
    }

    public static void main(String[] args) {
        PermutationInString permutationInString=new PermutationInString();
        System.out.println(permutationInString.checkInclusion("ab","eidbaooo"));
    }
}
