package main.java.arraysstrings;

public class MaxPossibleValue {

    public int solution(int N){
        boolean negSign = N<0?true:false;
        String s = String.valueOf(Math.abs(N));
        int ans = Integer.MIN_VALUE;
        for(int i =0; i< s.length();i++){
            if (s.charAt(i) == '5'){
                String firsHalf = s.substring(0,i);
                String secondHalf = s.substring(i+1,s.length());
                int temp = negSign?Integer.valueOf('-'+firsHalf+secondHalf):Integer.valueOf(firsHalf + secondHalf);
                ans = Math.max(ans,temp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxPossibleValue maxPossibleValue = new MaxPossibleValue();
        System.out.println(maxPossibleValue.solution(5050));
    }
}
