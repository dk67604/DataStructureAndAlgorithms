package main.java.ctci.arraysandstrings;

public class PalindromePermutation {

    public static void main(String[] args) {
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        System.out.println(palindromePermutation.isPermutationOfPalindrome("tact coa"));
        System.out.println(palindromePermutation.isPermutationOfPalindrome("tact coat"));

    }

    public boolean isPermutationOfPalindrome(String phrase) {
        int bitVector = createBitVector(phrase);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }

    private int createBitVector(String phrase) {
        int bitVector = 0;
        for (char c : phrase.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            int x = c - 'a';
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    private int toggle(int bitVector, int index) {
        if (index < 0) return bitVector;
        int mask = 1 << index;
        if ((bitVector & mask) == 0) {
            bitVector |= mask; //set ith bit
        } else {
            bitVector &= ~mask; // toggle ith bit
        }
        return bitVector;
    }

    private boolean checkExactlyOneBitSet(int bitVector) {
        return ((bitVector & (bitVector - 1))) == 0;
    }
}
