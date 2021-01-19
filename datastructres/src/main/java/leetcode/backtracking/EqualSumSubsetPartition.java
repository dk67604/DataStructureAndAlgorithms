package main.java.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class EqualSumSubsetPartition {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum =0;
        for(int num : nums)
            sum +=num;
        if(sum % k != 0)return false;
        if(nums.length < k ) return false;

        return canPartition(nums,new boolean[nums.length],0,k,0,sum/k);

    }

    private boolean canPartition(int[] nums,boolean[] used, int start,int k,int curSum,int subSum ){
        if(k == 1) return true;
        if(curSum > subSum) return false;
        // when a subset has sum equal the current sum, then explore new subset
        if(curSum == subSum) return canPartition(nums,used,0, k-1,0,subSum);
        for(int i =start ; i < nums.length;i++){
            if(used[i] == true) continue;
            used[i] = true;
            if(canPartition(nums,used,i+1,k,curSum + nums[i],subSum))
                return true;
            used[i] = false;
        }
        return false;
    }

    public List<List<Integer>> possiblePartitionKSubsets(int[] nums, int k){
        int sum =0;
        for(int num : nums)
            sum +=num;
        if(sum % k != 0)return new ArrayList<>();
        if(nums.length < k ) return new ArrayList<>();
        List<List<Integer>> subsets = new ArrayList<>();
        for(int i =0; i<k;i++){
            subsets.add(new ArrayList<>());
        }
        List<List<Integer>> result = new ArrayList<>();
        possiblePartitionKSubsets(nums,0,nums.length,k,new int[k],0,subsets,result);

        return result;
    }

    private void possiblePartitionKSubsets(int[] nums,int vidx,int n,int k, int[] subSetsSum,int countSubSet,
                                           List<List<Integer>> subsets,List<List<Integer>> result){
        if(vidx  == n){
            if (countSubSet == k){
                boolean flag = true;
                for (int i =0; i < subSetsSum.length-1;i++){
                    if(subSetsSum[i] != subSetsSum[i+1]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                        for (List<Integer> partition:subsets){
                            System.out.print(partition);
                            result.add(new ArrayList<>(partition));
                        }
                    System.out.println();
                }
            }
            return;
        }
        for(int i =0; i< subsets.size();i++){
            if(subsets.get(i).size() > 0){
                subsets.get(i).add(nums[vidx]);
                subSetsSum[i] += nums[vidx];
                possiblePartitionKSubsets(nums, vidx+1, n, k, subSetsSum, countSubSet, subsets,result);
                subSetsSum[i] -= nums[vidx];
                subsets.get(i).remove(subsets.get(i).size() -1);
            }
            else {
                subsets.get(i).add(nums[vidx]);
                subSetsSum[i] += nums[vidx];
                possiblePartitionKSubsets(nums, vidx+1, n, k, subSetsSum, countSubSet+1, subsets,result);
                subSetsSum[i] -= nums[vidx];
                subsets.get(i).remove(subsets.get(i).size() -1);
                break;

            }
        }

    }

    public static void main(String[] args) {
        EqualSumSubsetPartition equalSumSubsetPartition = new EqualSumSubsetPartition();
        int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        System.out.println(equalSumSubsetPartition.possiblePartitionKSubsets(nums,k));
    }
}
