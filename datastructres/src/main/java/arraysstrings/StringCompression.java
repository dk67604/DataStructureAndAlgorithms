package main.java.arraysstrings;

public class StringCompression {

        private String compress(String str){

            StringBuilder sb = new StringBuilder();
            int count =0;
            for(int i=0; i<str.length(); i++){
                count++;
                //if the next character is different than current,append this char to the result
                if (i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
                    sb.append(str.charAt(i)).append(count);
                    count=0;
                }

            }
            return  sb.length()<str.length()?sb.toString():str;
        }

    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();
        String test1 = "aabcccccaaa";
        System.out.println(stringCompression.compress(test1));
        String test2 = "aaaaaaabcccccaaa";
        System.out.println(stringCompression.compress(test2));
        String test3 = "abcd";
        System.out.println(stringCompression.compress(test3));
    }
}
