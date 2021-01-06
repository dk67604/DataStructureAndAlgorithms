package main.java.arraysstrings;

public class CaesarCipher {

    public static String caesarCipher(String s, int k) {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< s.length();i++){
           if(Character.isUpperCase(s.charAt(i))){
               char ch = (char)(((int)s.charAt(i) + k - 65)%26 + 65);
               sb.append(ch);
           }
           else if(Character.isLowerCase(s.charAt(i))){
               char ch = (char)(((int)s.charAt(i) + k - 97)%26 + 97);
               sb.append(ch);
           }
           else if(Character.isDigit(s.charAt(i))){
               int ch = Integer.valueOf(s.substring(i,i+1));

               int temp = ch+k < 9? ch +k: Math.abs( ch + k - 10)%10 ;
               sb.append(temp);
           }
            else {
                sb.append(s.charAt(i));
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "Zebra-493";
        int k = 3;
        System.out.println(caesarCipher(s,k));
    }
}
