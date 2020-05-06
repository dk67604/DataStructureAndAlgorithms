package main.java.leetcode;

import java.util.Arrays;

public class RemoveDuplicateFromString {

    public String removeDuplicate(String s){
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        s = new String(temp);
        char[] sortedChar = s.toCharArray();
        int i=1,j=1;
        // In place deletion
        while (i!=sortedChar.length){
            if (sortedChar[i]!=sortedChar[i-1]){
                sortedChar[j]=sortedChar[i];
                j++;
            }
            i++;
        }
        s = new String(sortedChar);
        return s.substring(0,j);
    }

    public String unique(String s){
        String str = new String();
        int len = s.length();
        for (int i=0;i<len;i++){
            char c = s.charAt(i);
            if(str.indexOf(c)<0){
                str+=c;

            }
        }
        return str;
    }

    public static void main(String[] args) {
        String s = "aaabbbacd";
        RemoveDuplicateFromString removeDuplicateFromString = new RemoveDuplicateFromString();
        System.out.println(removeDuplicateFromString.removeDuplicate(s));
        System.out.println(removeDuplicateFromString.removeDuplicate("leetcode"));
        System.out.println(removeDuplicateFromString.unique("leetcode"));
    }
}
