package main.java.dsa_2024.algorithms;

public class LongestTurbulentArray {
    public int maxTurbulenceSize(int[] nums){
        int l =0, r = 1;
        int res =1;
        String prev = "";
        while (r < nums.length) {
            if(nums[r-1] > nums[r] && prev != ">"){
                res = Math.max(r - l + 1, res);
                r += 1;
                prev = ">";
            }
            else if(nums[r - 1] < nums[r] && prev != "<"){
                res = Math.max(r - l + 1, res);
                r += 1;
                prev = "<";
            }
            else{
                r = nums[r] == nums[r-1]? r + 1: r;
                l = r-1;
                prev = "";
            }
        }
        return res;
    }
}
