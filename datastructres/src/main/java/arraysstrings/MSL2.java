package main.java.arraysstrings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MSL2 {
    int solution (int [] A) {
        int N = A. length;
        int result = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (A[i] == A[j])
                    result = Math.max(result, Math.abs(i- j));
        return result;
    }
    int solution2 (int [] A) {
        int N = A. length;
        int result = 0;
        Map<Integer, LinkedList<Integer>> lookup = new HashMap<>();
        for (int i =0; i< N; i++){
            if(lookup.containsKey(A[i])){
                lookup.get(A[i]).addLast(i);
            }
            else {
                lookup.put(A[i], new LinkedList<>());
                lookup.get(A[i]).addLast(i);
            }
        }
        for (Map.Entry<Integer, LinkedList<Integer>> entry: lookup.entrySet()){
            if (entry.getValue().size()==1)
                continue;
            int i = entry.getValue().getFirst();
            int j = entry.getValue().getLast();
            result = Math.max(result, Math.abs(i- j));
        }
        return result;
    }

    public static void main(String[] args) {
        int []A = new int[50001];
        for(int i =0; i<50001;i++){
            A[i] =2;
        }
        System.out.println(A.length);
        MSL2 msl2 = new MSL2();
        System.out.println(msl2.solution2(A));
        System.out.println(msl2.solution2(new int[]{1,2,3}));
    }
}
