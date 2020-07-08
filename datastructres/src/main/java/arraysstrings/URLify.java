package main.java.arraysstrings;

/*
URLify: Write a method to replace all spaces in a string with '%2e: You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: if implementing in Java, please use a character array so that you can
perform this operation in place.)
EXAMPLE
Input: "Mr John Smith JJ, 13
Output: "Mr%2eJohn%2eSmith"

ConstructLinkedList:
The algorithm employs a two-scan approach. In the first scan, we
count the number of spaces.
By tripling this number, we can compute how many extra characters we will
have in the final string. In the second pass, which is done in reverse order,
we actually edit the string. When
we see a space, we replace it with %20.
If there is no space, then we copy the original character.
 */


public class URLify {
    public void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0,index=0;
        for (int i =0;i<trueLength;i++){
            if(str[i] == ' '){
                spaceCount++;
            }
        }
        // Triple the number to compute how many extra characters is required
        index = trueLength + spaceCount*2;
        if (trueLength < str.length) str[trueLength] = '\0'; //End Array
        for (int i = trueLength -1;i>=0;i--){
            if (str[i] == ' '){
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index -3;
            }else {
                str[index -1] = str[i];
                index--;
            }
        }
        System.out.println(String.valueOf(str));
    }

    public static void main(String[] args) {
        URLify urLify = new URLify();
        String str ="Mr John Smith    ";
        int trueLength = 13;
        urLify.replaceSpaces(str.toCharArray(),trueLength);
    }
}
