package main.java.arraysstrings;

/*1.4 Palindrome Permutation: Given a string, write a function to check if it is a permutation of
        a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
        permutation is a rearrangement of letters. The palindrome does not need to be limited to just
        dictionary words.
        EXAMPLE
        Input: Tact Coa
        Output: True (permutations:"taco cat'; "atco cta'; etc.)*/

public class PalindromePermutation {

    private boolean isPermuationOfPalindrome(String phrase){
        int bV = createBitVector(phrase);
        return bV == 0 || checkExactlyOneBitSet(bV);
    }

    private int createBitVector(String phrase){
        int bV = 0;
        phrase = phrase.toLowerCase();
        for(char c:phrase.toCharArray()){
            if(c == ' ')
                continue;
            int x = c - 'a';
            bV = toggle(bV,x);
        }
        return  bV;
    }

    private int toggle(int bV,int index){
        //Create mask by shifting left one bit by index position
        if (index < 0) return bV;
        int mask = 1 << index;
        //Check if the bitVector is toggled by taking and if equals the bit vector required to toggle
        if((bV & mask) == 0){
            bV |=mask ;// by or with mask the set index'th bit toggled
        }else {
            //Get the index'th bit which is already toggled
            bV&=~mask;
        }
        return bV;
    }

    private boolean checkExactlyOneBitSet(int bV){
        // by subtracting one from bit Vector ANDing with the original bit vector equals zero
        return (bV & (bV -1)) ==0;
    }

    public static void main(String[] args) {
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        String test1 = "Tact Coa";
        System.out.println("Palindrom Permutation:"+palindromePermutation.isPermuationOfPalindrome(test1));
        String test2 = "Nitin";
        System.out.println("Palindrom Permutation:"+palindromePermutation.isPermuationOfPalindrome(test2));
        String test3 = "Malayalam";
        System.out.println("Palindrom Permutation:"+palindromePermutation.isPermuationOfPalindrome(test3));
        String test4 = "I love my nation";
        System.out.println("Palindrom Permutation:"+palindromePermutation.isPermuationOfPalindrome(test4));


    }
}
