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
}
