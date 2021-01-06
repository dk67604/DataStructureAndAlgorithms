package main.java.arraysstrings;

public class EncryptedWord {

    private int findMiddleIndex(String s){
        int len = s.length();
        if(len % 2 == 0)
            return len/2 - 1;
        else return len/2;
    }

    String findEncryptedWord(String s) {
        // Write your code here
        int middleIndex = findMiddleIndex(s);
        char ch = s.charAt(middleIndex);
        StringBuilder res = new StringBuilder();
        res.append(ch);
        return helper(s,ch,res,middleIndex,s.length()).toString();
    }

    private StringBuilder helper(String input,char ch, StringBuilder res,int middleIndex,int length){
        if( res.length() == length){
            return res;
        }

        String left = "";
        left = input.substring(0, middleIndex);
        String right = "";
        right = input.substring(middleIndex+1);
        if(left.length() >0){
            middleIndex = findMiddleIndex(left);
            if(middleIndex >= 0 ){
                ch = left.charAt(middleIndex);
                res.append(ch);
                res = helper(left,ch,res,middleIndex,length);
            }
        }

        if(right.length() >0){
            middleIndex = findMiddleIndex(right);
            if(middleIndex >=0 ){
                ch = right.charAt(middleIndex);
                res.append(ch);
                res = helper(right,ch,res,middleIndex,length);
            }
        }

        return res;

    }

    public static void main(String[] args) {
        EncryptedWord encryptedWord = new EncryptedWord();
        System.out.println(encryptedWord.findEncryptedWord("facebook"));
    }
}
