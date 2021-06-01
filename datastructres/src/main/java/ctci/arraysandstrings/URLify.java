package main.java.ctci.arraysandstrings;

public class URLify {
    public static void main(String[] args) {
        URLify urLify = new URLify();
        urLify.replaceSpaces("Mr John Smith     ", 13);
    }

    public void replaceSpaces(String str, int trueLength) {
        char[] strArray = str.toCharArray();
        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (strArray[i] == ' ')
                spaceCount++;
        }
        int index = trueLength + spaceCount * 2;
        if (trueLength < str.length()) strArray[trueLength] = '\0';
        for (int i = trueLength - 1; i >= 0; i--) {
            if (strArray[i] == ' ') {
                strArray[index - 1] = '0';
                strArray[index - 2] = '2';
                strArray[index - 3] = '%';
                index = index - 3;
            } else {
                strArray[index - 1] = strArray[i];
                index--;
            }

        }
        System.out.println(strArray);
    }
}
