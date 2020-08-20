package main.java.arraysstrings;

public class LargestLetter {

    public String solution(String S){
        int[] lookup = new int[52];
        char[] str = S.toCharArray();
        String ans= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(char c : str){
            if(c>=97 && c<=122){
                lookup[c-'a']=1;
            }
            else if(c>=65 && c<=90){
                lookup[c-'A'+26] =1;
            }
        }
        int max= -1;
        for (int i =0;i<26;i++){
            if(lookup[i] ==1 && lookup[i+26]==1){
                max= i+26;
            }
        }
        return max ==-1?"NO":ans.substring(max-26,max-26+1);
    }

    public static void main(String[] args) {
        LargestLetter largestLetter = new LargestLetter();
        String S= "WeTestCodErs";
        System.out.println(largestLetter.solution(S));
    }
}
