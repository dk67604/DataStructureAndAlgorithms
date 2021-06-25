package main.java.topcodingquestion.subsets;

import java.util.*;

public class Permutations {

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutation = new LinkedList<>();
        permutation.add(new ArrayList<>());
        for (int currentNumber : nums) {
            // we will take all existing permutations and add the current number to create new permutations
            int n = permutation.size();
            // create a new permutation by adding the current number at every position
            for (int i = 0; i < n; i++) {
                List<Integer> oldPermutation = permutation.poll();
                for (int j = 0; j <= oldPermutation.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);
                    newPermutation.add(j, currentNumber);
                    if (newPermutation.size() == nums.length) {
                        result.add(newPermutation);
                    } else
                        permutation.add(newPermutation);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[]{1, 3, 5});
        System.out.print("Here are all the permutations: " + result);
    }

    //Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
    public List<List<Integer>> findPermutationsII(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //count the occurrence of each number
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        LinkedList<Integer> comb = new LinkedList<>();
        backtrack(comb, nums.length, countMap, result);
        return result;
    }

    private void backtrack(LinkedList<Integer> comb, int length, Map<Integer, Integer> countMap,
                           List<List<Integer>> result) {
        if (comb.size() == length) {
            // make a deep copy of the resulting permutation,
            // since the permutation would be backtracked later.
            result.add(new ArrayList<>(comb));
            return;
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            //Start creating permutation from unique values present the count map
            int num = entry.getKey();
            int count = entry.getValue();
            if (count == 0)
                continue; //This means we have exhausted the current num so go to the next value
            comb.add(num); //Add the candidate available to create a new permutation
            countMap.put(num, count - 1);//For the current exploration decrease the count
            //continue the exploration
            backtrack(comb, length, countMap, result);
            //revert the changes made in previous exploration to form new permutation
            comb.removeLast();
            countMap.put(num, count);
        }
    }
}
