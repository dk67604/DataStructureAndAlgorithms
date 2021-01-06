package main.java.educative.io.coding.subsets;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class AbbreviatedWord{
    StringBuilder str;
    int start;
    int count;
    public AbbreviatedWord(StringBuilder s,int start,int count){
        this.str =s;
        this.start = start;
        this.count = count;
    }
}

public class GeneralizedAbbreviation {

    public static List<String> generateGeneralizedAbbreviation(String word) {
        int wordLength = word.length();
        List<String> result = new ArrayList<String>();
        Queue<AbbreviatedWord> queue = new LinkedList<>();
        queue.add(new AbbreviatedWord(new StringBuilder(),0,0));
        while (!queue.isEmpty()){
            AbbreviatedWord abWord = queue.poll();
            if(abWord.start == wordLength){
                if(abWord.count !=0){
                    abWord.str.append(abWord.count);
                }
                result.add(abWord.str.toString());
            }
            else{
                // continue abbreviating by incrementing the current abbreviation count
                queue.add(new AbbreviatedWord(new StringBuilder(abWord.str),abWord.start+1,abWord.count+1));
                // restart abbreviating, append the count and the current character to the string
                if(abWord.count != 0)
                    abWord.str.append(abWord.count);
                queue.add(new AbbreviatedWord(new StringBuilder(abWord.str).append(word.charAt(abWord.start)),abWord.start+1,0));
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<String> result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("BAT");
        System.out.println("Generalized abbreviation are: " + result);

        result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("code");
        System.out.println("Generalized abbreviation are: " + result);
    }
}
