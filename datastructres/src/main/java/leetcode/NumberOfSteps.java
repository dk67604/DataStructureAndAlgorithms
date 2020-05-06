package main.java.leetcode;


public class NumberOfSteps {
    public int numberOfSteps (int num) {
        int count=0;
        count=recursion(num,count);
        return count;

    }

    private int recursion(int num,int count){

        if(num ==0) return count;
        else if(num % 2 ==0 ){
            num/=2 ;
            count= 1+ recursion(num,count);
            return count;
        }
        else{
            num-=1;

            count= 1 +recursion(num,count);
            return count;
        }
    }

    public static void main(String[] args) {
        NumberOfSteps numberOfSteps=new NumberOfSteps();
        numberOfSteps.numberOfSteps(14);
    }
}
