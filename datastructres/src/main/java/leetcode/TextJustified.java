package main.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustified {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i =0, n = words.length;
        //Using two pointer i and j, we increase j as long as the width of the line is less than maxWidth
        while (i < n){
            int j = i+1; // increase j by to see can a word at index j to be part of line
            int lineLength = words[i].length();// current word at index i length
            //Check if by increasing j can it be possible
            // j-i-1 indicated number of spaces required between words from index i to j
            while (j < n && (lineLength + words[j].length() +(j-i-1) < maxWidth)){
                lineLength += words[j].length(); // if we can include a word at index j we will increase lineLength
                ++j; // keep on increasing j until while condition violate
            }
            int numberOfWords = j - i; //number of wrd required for justification
            int diff = maxWidth - lineLength; // number spaces need to filled in a line to make it justified
            if(numberOfWords == 1 || j >= n) {
                // this is a condition for left justification
                result.add(leftJustify(words,diff,i,j));
            }
            else{
                result.add(rightJustify(words,diff,i,j));
            }
            i =j;
        }
        return result;
    }

    private String leftJustify(String[] words, int diff, int i ,int j){
        int spacesOnRight = diff - (j - i -1);
        StringBuilder sb = new StringBuilder(words[i]);
        for(int k = i+1 ; k<j;++k){
            sb.append(" " +words[k]);
        }
        sb.append(" ".repeat(spacesOnRight));
        return sb.toString();
    }

    private String rightJustify(String[] words, int diff, int i ,int j){
        int spaceNeeded = j-i-1;
        int spaces = diff /(spaceNeeded);
        int extraSpaces = diff % (spaceNeeded);
        StringBuilder sb = new StringBuilder(words[i]);
        for (int k = i+1; k<j;k++){
            int spaceToApply = spaces + (extraSpaces-- > 0?1:0);
            sb.append(" ".repeat(spaceToApply) + words[k]);
        }
        return sb.toString();
    }
}
