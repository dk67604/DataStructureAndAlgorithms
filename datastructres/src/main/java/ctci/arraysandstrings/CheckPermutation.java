package main.java.ctci.arraysandstrings;

public class CheckPermutation {

    public static void main(String[] args) {
        CheckPermutation checkPermutation = new CheckPermutation();
        String str1 = "dog";
        String str2 = "god";
        System.out.println(checkPermutation.checkPairIsPermutation(str1, str2));
        str1 = "cat";
        str2 = "tac";
        System.out.println(checkPermutation.checkPairIsPermutation(str1, str2));
        str1 = "yolo";
        str2 = "olyo";
        System.out.println(checkPermutation.checkPairIsPermutation(str1, str2));
    }

    public boolean checkPairIsPermutation(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        for (int i = 0, j = n - 1; i < m & j >= 0; i++, j--) {
            int checker1 = 0, checker2 = 0;
            int val1 = str1.charAt(i) - 'a';
            int val2 = str2.charAt(j) - 'a';
            checker1 |= 1 << val1;
            checker2 |= 1 << val2;
            int result = checker1 & checker2;
            if (result == 0)
                return false;
        }
        return true;

    }
}
