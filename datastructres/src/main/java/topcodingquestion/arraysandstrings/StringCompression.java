package main.java.topcodingquestion.arraysandstrings;

public class StringCompression {
    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();
        System.out.println(stringCompression.compression("aaabbffh"));
        System.out.println(stringCompression.compression("abcd"));
    }

    public String compression(String phrase) {
        StringBuilder sb = new StringBuilder();
        int len = phrase.length();
        int count = 1;
        for (int i = 0; i < len - 1; i++) {
            if (phrase.charAt(i) != phrase.charAt(i + 1)) {
                sb.append(phrase.charAt(i));
                sb.append(count);
                count = 1;
            } else {
                count += 1;
            }
        }
        return phrase.length() <= sb.toString().length() ? phrase : sb.toString();
    }
    // https://leetcode.com/problems/string-compression/
    public int compress(char[] chars){
        int i =0;
        int index  = 0;
        while (i< chars.length){
            int j = i;
            while (j< chars.length && chars[j] == chars[i]){
                j++;
            }
            chars[index++] = chars[i];
            if(j - i > 1){
                String count = j-i + "";
                for (char ch: count.toCharArray()){
                    chars[index++] = ch;
                }
            }
            i = j;
        }
        return index;
    }
}
