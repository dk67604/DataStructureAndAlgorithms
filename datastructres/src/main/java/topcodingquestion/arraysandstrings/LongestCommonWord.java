package main.java.topcodingquestion.arraysandstrings;

//https://www.geeksforgeeks.org/longest-common-substring-array-strings/
public class LongestCommonWord {
    public static String findLongestWord(String words) {
        String[] allWords = words.split(",");
        String startWord = allWords[0];
        int n = allWords.length;
        int len = startWord.length();
        String res = "";
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                // generating all possible substrings
                // of our reference string arr[0] i.e s
                String stem = startWord.substring(i, j);
                int k = 1;
                for (k = 1; k < n; k++) {
                    // Check if the generated stem is
                    // common to all words
                    if (!allWords[k].contains(stem))
                        break;
                }
                // If current substring is present in
                // all strings and its length is greater
                // than current result
                if (k == n && res.length() < stem.length()) {
                    res = stem;
                }

            }
        }
        return res;
    }

    // Driver Code
    public static void main(String[] args) {
        String words = "grace,graceful,disgraceful,gracefully";

        // Function call
        String stems = findLongestWord(words);
        System.out.println(stems);
    }
}
