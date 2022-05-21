package main.java.topcodingquestion.stacks;

public class MinimumSwapStringBalanced {

    public int minSwaps(String s){
        int len = s.length();
        int balance = 0, swaps =0, j =len -1;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i< len;i++){
            if (sb.charAt(i) == '[') balance++;
            else balance--;
            if(balance < 0){
                while (i < j && sb.charAt(j) == '['){
                    j --;
                }
                char temp = sb.charAt(i);
                sb.setCharAt(i,sb.charAt(j));
                sb.setCharAt(j,temp);
                swaps++;
                balance = 1;
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        MinimumSwapStringBalanced minimumSwapStringBalanced = new MinimumSwapStringBalanced();
        System.out.println(minimumSwapStringBalanced.minSwaps("[]]][[]["));

    }
}
