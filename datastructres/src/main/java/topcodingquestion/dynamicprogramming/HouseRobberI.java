package main.java.topcodingquestion.dynamicprogramming;

public class HouseRobberI {
    public int rob(int[] nums){
        int rob1=0,rob2=0;
        for(int n: nums){
            int temp = Math.max(n+ rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
