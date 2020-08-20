package main.java.arraysstrings;

public class MaximumGreater {

    public int solution(int N){
        int max = N;
        String s = String.valueOf(Math.abs(N));
        String t = "5";
        int length =  N==0?1:(int) (Math.log10(Math.abs(N)) + 1);

        for(int i = 0;i<=length;i++){

            if(i==0){
                String temp = t+s;
                if(N<0){
                    max = Math.min(max,-Integer.parseInt(temp));
                }
                else{
                    max = Math.max(max,Integer.parseInt(temp));
                }

            }
            else {
                String temp = s.substring(0,i)+t+s.substring(i,s.length());
                if(N<0){
                    max = Math.max(max,-Integer.parseInt(temp));
                }
                else{
                    max = Math.max(max,Integer.parseInt(temp));
                }
            }

        }
        return max;
    }

    public static void main(String[] args) {
        MaximumGreater maximumGreater = new MaximumGreater();
        System.out.println(maximumGreater.solution(999));
    }
}
