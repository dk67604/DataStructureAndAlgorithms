package main.java.arraysstrings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExpression {

    public String extract(String line, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        String extractWord = null;
        if(matcher.find()){
            extractWord = matcher.group(1);
        }
        return extractWord;
    }
    public boolean matchPattern(String line,String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }

    public static void main(String[] args) {
        RegexExpression regexExpression = new RegexExpression();
        String line = "/pfm/v1/08055/sessions";
        String regex= "\\/pfm\\/v1/(\\d{5})\\/";
        String line2 = "/v2/fis/DI3323/fiCustomers/b33264360023658c5621323c0d5de714/userOffers?markAsServed=false";
        String regex2 = "\\/fis\\/((DI)?(\\d{4,5}))\\/";
        String regex3 = "^(.*\\.digitalinsight\\.com)+(.*)$";
        String line3 = "api.qal1.digitalinsight.com";
        System.out.println(regexExpression.matchPattern(line3,regex3));
        System.out.println(regexExpression.extract(line,regex2));
    }
}
