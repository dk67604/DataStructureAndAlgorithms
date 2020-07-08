package main.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchProduct {
    /*
Intuition here is to use binary prefix search from both the ends
of the array products.
Index start is increased when we find prefix match at the start of array products,
and decrease the index when we find prefix match at the end.
Both index updated till match not found.
At the end use start and end index to slice the array and add it to the final result.
        */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        if(products == null || products.length == 0 || searchWord == null || searchWord.length() == 0){
            return result;
        }
        int n = products.length;
        int start = 0, end = n - 1;
        int len = searchWord.length();
        Arrays.sort(products);

        for(int i = 0; i < len; i++){
            while(start <= end && (products[start].length() <= i || products[start].charAt(i) != searchWord.charAt(i))){
                start++;
            }

            while(start <= end && (products[end].length() <= i || products[end].charAt(i) != searchWord.charAt(i))){
                end--;
            }

            List<String> candidates = new ArrayList<>();
            for(int j = start; j <= end && j < start + 3; j++){
                candidates.add(products[j]);
            }
            result.add(candidates);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] product = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord ="mou";
        SearchProduct searchProduct = new SearchProduct();
        searchProduct.suggestedProducts(product,searchWord);
    }
}
