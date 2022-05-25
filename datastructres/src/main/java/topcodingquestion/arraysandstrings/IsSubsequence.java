package main.java.topcodingquestion.arraysandstrings;

public class IsSubsequence {
  public boolean isSubsequence(String s, String t) {
       int left = s.length();
       int right = t.length();
       int pLeft = 0, pRight = 0;
       while(pLeft<left && pRight < right){
           if(s.charAt(pLeft) == t.charAt(pRight)){
               pLeft++;
           }
           pRight++;
       }
        return pLeft == left;
    }
}
