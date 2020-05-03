package main.java.arraysstrings;

public class IsUnique {
    // Assumption all the character in the string is lowercase and only 128-character alphabet
    // It can be extended to include ASCII i.e. 256 character
    private boolean isUnique(String s){

        // 32-bit unsigned vector
        int checker = 0;
        for(int i =0; i<s.length();i++){
            //get the distance from 'a' so we have the value in the range 0 and 25,
            // of the 32 bits available
            int val = s.charAt(i) -'a';
            //Shift distance from one bit to the left, if bitwise & with checker is greater than zero,
            // the character isn't unique
            if((checker & (1 << val))>0){
                return false;
            }
            //bitwise or with 1 turns a bit on the position at the val
            checker|= (1<<val);

        }
        return true;

    }

    // Driver method to test
    public static void main(String[] args) {
        String [] tests = {"abcd","aa","bcdbbb","abcdabcd"};
        IsUnique isUnique = new IsUnique();
        for (int t=0;t<tests.length;t++){
            System.out.println(isUnique.isUnique(tests[t]));
        }

    }
}
