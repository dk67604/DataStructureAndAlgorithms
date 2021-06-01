package main.java.ctci.arraysandstrings;

public class OneEditAway {

    public static void main(String[] args) {
        OneEditAway oneEditAway = new OneEditAway();
        System.out.println(oneEditAway.oneEditAway("andy", "andy k"));
        System.out.println(oneEditAway.oneEditAway("acbbcda", "abbdad"));
    }

    public boolean oneEditAway(String str1, String str2) {


        String newstr1 = str1.replace(" ", "");
        String newstr2 = str2.replace(" ", "");
        if (Math.abs(newstr1.length() - newstr2.length()) > 1) {
            return false;
        }
        String s1 = newstr1.length() < newstr2.length() ? newstr1 : newstr2;
        String s2 = newstr1.length() < newstr2.length() ? newstr2 : newstr1;
        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) == ' ') index1++;
            if (s2.charAt(index2) == ' ') index2++;
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundDifference) return false;
                foundDifference = true;
                if (s1.length() == s2.length()) {
                    index1++; //replace
                }
            } else {
                index1++; //match
            }
            index2++;
        }
        return true;
    }
}
