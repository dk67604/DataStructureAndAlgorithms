package main.java.topcodingquestion.backtracking;

import java.util.concurrent.atomic.AtomicInteger;

public class FriendsPairing {
    static int counter = 1;

    public static void solution(int i, int n , boolean[] used, String asf){
        if ( i > n){
            System.out.println(counter+ "." + asf);
            counter++;
            return;
        }
        if (used[i]){ // no call
            solution(i+1,n,used,asf);
        }else { // yes call
            used[i] = true;
            solution(i+1, n, used, asf + "(" + i + ") " );
            for(int j = i+1; j<=n;j++){
                if(!used[j]){
                    used[j] = true;
                    solution(i+1,n, used, asf+"(" + i + "," + j + ") ");
                    used[j] = false; //backtrack
                }
            }
            used[i] = false; // backtrack
        }
    }

    public static void main(String[] args) {
        int n =3;
        solution(1,n, new boolean[n+1],"");
    }
}
