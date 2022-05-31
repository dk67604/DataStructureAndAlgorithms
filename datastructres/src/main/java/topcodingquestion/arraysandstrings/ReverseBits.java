package main.java.topcodingquestion.arraysandstrings;

public class ReverseBits {

    public int reverseBits(int n){
        int res  = 0;
        for (int i =0; i< 32;i++){
            int bit = (n >> i) & 1; //Get ith bit by shifting right and with 1
            res = res | (bit <<(31-i)); //Shift by 31-i so that we put at most significant bit
        }
        return res;
    }
}
