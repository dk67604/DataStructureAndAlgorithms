package main.java.dsa_2024.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subset {

    public static List<List<Integer>> findSubsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for( int currentNumber: nums){
            int n = result.size();
            for (int i =0; i< n; i++){
                List<Integer> set = new ArrayList<>(result.get(i));
                set.add(currentNumber);
                result.add(set);
            }
        }
        return result;
    }

}
