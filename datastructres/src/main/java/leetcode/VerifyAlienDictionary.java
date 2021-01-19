package main.java.leetcode;

public class VerifyAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderLookup = new int[26];
        for(int i =0 ; i<order.length();i++){
            orderLookup[order.charAt(i) - 'a'] = i;
        }
        for(int i =1;i < words.length ;i++){
            if(checkOrder(words[i-1],words[i],orderLookup))return false;
        }
        return true;
    }

    private boolean checkOrder(String w1, String w2,int[] orderLookup){
        int n = w1.length();
        int m = w2.length();
        for(int i =0;i< Math.min(n,m); i++){
            if(w1.charAt(i) != w2.charAt(i)){
                return orderLookup[w1.charAt(i)-'a'] > orderLookup[w2.charAt(i)-'a'];
            }
        }
        return n > m;
    }

    public static void main(String[] args) {
        String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        VerifyAlienDictionary verifyAlienDictionary = new VerifyAlienDictionary();
        System.out.println(verifyAlienDictionary.isAlienSorted(words,order));
    }
}
