package main.java.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RemoveAdjacentDuplicate {
    public String removeDuplicates(String S) {
        char[] stack=new char[S.length()];
        int i=0;
        int len=S.length();
        for(int j=0;j<len;j++){
            if(i>0 && stack[i-1]==S.charAt(j)){
                --i;
            }
            else{
                stack[i++]=S.charAt(j);
            }
        }
        return new String(stack,0,i);
    }
    public String recursiveRemoveDuplicate(String s){
       int[] count = new int[26];
       int max = Integer.MIN_VALUE;
       boolean[] visited = new boolean[26];
       // Code to find the max length of adjacent duplicate character
       for (int i =0 ; i<s.length();i++){
           if(!visited[s.charAt(i)-'a']){
                   count[s.charAt(i)-'a'] =1;
                   visited[s.charAt(i) -'a'] = true;
               }
           }

       for (int i=0;i<s.length()-1;i++){
           int j=i;
           if(visited[s.charAt(i) - 'a']){
               int prevLen = count[s.charAt(i) - 'a'];
               count[s.charAt(i) - 'a'] =0;
               int k= j;
               while (j<s.length()-1 & s.charAt(k) == s.charAt(j)){
                   j++;
                   count[s.charAt(i) - 'a']+=1;
               }
               if(j == s.length() -1 & s.charAt(j) == s.charAt(j-1)){
                   count[s.charAt(i) - 'a']+=1;
               }
               count[s.charAt(i) - 'a'] = Math.max(prevLen,count[s.charAt(i) - 'a']);

               i=j-1;
           }

       }
       for (int i:count){
           max = Math.max(i,max);
       }
       String res = new String();
       // Call recursively until 1 length of unique character
       for (int i=max;i>=1;i--){
           res = removeDuplicatesII(s,i);
           if(res.length()<=2 || res.charAt(0)!=res.charAt(1)){
               return res;
           }
           s=res;
       }
       return res;
    }

    public String removeDuplicatesII(String  s,int k){
        Stack<Integer> stack = new Stack<>();
        int j=0;
        char[] schar = s.toCharArray();
        for (int i =0;i<s.length();++i,++j){
            schar[j] = schar[i];
            if(j == 0 || schar[j]!=schar[j-1]){
                stack.push(1);
            }
            else{
                int increment = stack.pop()+1;
                if(increment ==k){
                    j=j-k;
                }
                else {
                    stack.push(increment);
                }
            }
        }
        return new String(schar,0,j);
    }

    public static String  check(String str)
    {
        if(str.length()<=1)
        {
            return str;
        }
        String n=new String();
        int count=0; //Check if the value greater than zero than
        for(int i=0;i<str.length();i++)
        {
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1))
            {
                if(i<str.length()-2 &&str.charAt(i)!=str.charAt(i+2))
                    i+=2;
                else
                    i++;
                count++;
            }
            if(i!=str.length()-1)
                n=n+str.charAt(i);
            else
            {if(i==str.length()-1 && str.charAt(i)!=str.charAt(i-1))
                n=n+str.charAt(i);
            }
        }
        if(count>0)
            return check(n);
        else
            return n;
    }


    public static void main(String[] args) {


        String s1= "acaaabbbacdddd";

        String s2 ="aacccdddb";
        RemoveAdjacentDuplicate removeAdjacentDuplicate = new RemoveAdjacentDuplicate();
        System.out.println(check("aacccdddb"));

        String str1 = "geeksforgeeg";
        System.out.println(check(str1));
        String str2 = "azxxxzy";
        System.out.println(check(str2));

        String str3 = "caaabbbaac";
        System.out.println(check(str3));

        String str4 = "gghhg";
        System.out.println(check(str4));

        String str5 = "aaaacddddcappp";
        System.out.println(check(str5));


        String str6 = "aaaaaaaaaa";
        System.out.println(check(str6));

        String str7 = "qpaaaaadaaaaadprq";
        System.out.println(check(str7));

        String str8 = "aabbbacd";
        System.out.println(check(str8));
        System.out.println(removeAdjacentDuplicate.removeDuplicatesII(str8,3));

        System.out.println(removeAdjacentDuplicate.recursiveRemoveDuplicate("geeksforgeeg"));
        System.out.println(removeAdjacentDuplicate.recursiveRemoveDuplicate(str8));
    }
}
