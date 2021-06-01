package main.java.ctci.arraysandstrings;


public class IsUnique {
    public static void main(String[] args) {
        IsUnique isUnique = new IsUnique();
//        System.out.println(isUnique.isUniqueChars("leetcode"));
        System.out.println(isUnique.isUniqueChars("ctci"));
    }

    public boolean isUniqueChars(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) != 0) {
                return false;
            }
            checker |= 1 << val;
        }
        return true;
    }
}
