package main.java.dsa_2024.algorithms;

public class RemoveDuplicatesII {
    public int removeDuplicates(int[] nums){
        int l = 0, r =0;
        while (r < nums.length) {
            int count = 1;
            while (r + 1 < nums.length && nums[r] == nums[r+1]) {
                r+=1;
                count++;
            }
            for(int i = 0; i < Math.min(2, count); i++){
                nums[l] = nums[r];
                l +=1;
            }
            r +=1;
        }
        return l;
    }
}
