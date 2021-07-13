package main.java.arraysstrings;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static String getDomainName(String url) throws URISyntaxException {
        URI uri = new URI(url);
        String domain = uri.getHost();
        return domain.startsWith("www.") ? domain.substring(4) : domain;
    }

    private static int findNthLastIndex(int nTh, char ch, String input) {
        int countDot = 0;
        int index = -1;
        for (int i = input.length() - 1; i >= 0; i--) {
            if (input.charAt(i) == ch) {
                countDot++;
                if (countDot == nTh) {
                    index = i;
                }
            }
            if (countDot == nTh) {
                break;
            }
        }
        return index;
    }

    private static boolean matchFirestoreHostToLogs(String[] sideInput, String[] hostParts) {
        boolean foundPartFirst = false;
        boolean foundPartSecond = false;
        for (String part : hostParts) {
            if (part.equals(sideInput[0])) {
                foundPartFirst = true;
            }
            if (part.equals(sideInput[1])) {
                foundPartSecond = true;
            }
        }
        return foundPartFirst && foundPartSecond;
    }

    static int nthLastIndexOf(int n, String ch, String string) {
        if (n <= 0) return string.length();
        return nthLastIndexOf(--n, ch, string.substring(0, string.lastIndexOf(ch)));
    }


    public static void main(String[] args) throws URISyntaxException {
        String[] input1 = "acuonline.org".split("\\.");
        String[] input2 = "digitalinsight.com".split("\\.");
        String host2 = "digitalinsight.com.cdn.cloudflare.net:8080";
        System.out.println(nthLastIndexOf(1, ".", host2));
        String host1 = "iaacuonline.org";
        int colonIndex = host2.indexOf(":");
        if (colonIndex != -1) {
            host2 = host2.substring(0, colonIndex);
        }
        System.out.println(nthLastIndexOf(2, ".", host2));

        System.out.println(host2.substring(findNthLastIndex(2, '.', host2) + 1));
        String[] tokens = host2.split("\\.");
        System.out.println(matchFirestoreHostToLogs(input2, tokens));
        String text = "www.digitalinsight.com.cdn.cloudflare.net:8080";

        Pattern pattern = Pattern.compile(".*\\bdigitalinsight.com.*");
        Matcher matcher = pattern.matcher(text);

        System.out.println("matcher.matches() = " + matcher.matches());


    }
}
