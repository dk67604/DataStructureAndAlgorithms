package main.java.topcodingquestion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PartitionInKSubsets {
    static int counter =0;

    private void solution(int i, int n, int k, int noOfSets,List<List<Integer>> ans, List<List<Integer>> result){
        if(i > n){
            if ( noOfSets == k ){
                counter++;
                for (List<Integer> set:ans){
                    result.add(new ArrayList<>(set));
                    System.out.print(set +" ");
                }
                System.out.println();
            }
            return;
        }

        for (int j =0; j< ans.size();j++){
            if(ans.get(j).size() > 0){
                ans.get(j).add(i);
                solution(i+1,n,k, noOfSets,ans,result);// no need to increase set because we're adding to same slot
                //backtrack
                ans.get(j).remove(ans.get(j).size()-1);
            }else{
                // add to any slot, we're adding to first available slot to avoid permutation as they are
                // treated as same slot
                ans.get(j).add(i);
                solution(i+1, n, k, noOfSets+1,ans,result);
                //backtrack
                ans.get(j).remove(ans.get(j).size()-1);
                break;
            }
        }
    }

    public int findNoOfPartition(int n, int k){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0;i<k;i++){
            ans.add(new ArrayList<>());
        }
        List<List<Integer>> result = new ArrayList<>();
        solution(1,n,k,0,ans,result);
        System.out.println(result);
        return counter;
    }

    public static void main(String[] args) {
        PartitionInKSubsets partitionInKSubsets = new PartitionInKSubsets();
        System.out.println("No of partion in K subsets: "+ partitionInKSubsets.findNoOfPartition(3,2));


    }
}
