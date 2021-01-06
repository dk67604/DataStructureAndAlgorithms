package main.java.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combinations(1,k,n,new LinkedList<Integer>(),result);
        return result;
    }
    private void combinations(int start,int k,int n,LinkedList<Integer> tempList,
                              List<List<Integer>> result){

        if(k < 0 || n < 0)
            return;
        if(k == 0 && n== 0){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = start;i <=9; i++){
            tempList.add(i);
            combinations(i+1,k-1,n-i,tempList,result);
            tempList.removeLast(); // do the backtrack
        }

    }
}
