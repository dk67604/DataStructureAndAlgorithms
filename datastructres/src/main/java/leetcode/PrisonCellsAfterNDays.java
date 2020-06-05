package main.java.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrisonCellsAfterNDays {

    public int[] prisonAfterNDays(int[] cells, int N) {
        if(cells == null || cells.length==0 || N<=0) return cells;
        boolean hasCycle=false;
        Set<String> set = new HashSet<>();
        int cycle =0;
        //Fist task we will find the value of cycle, where pattern starts repeating
        for(int i =0;i<N;i++){
            int[] next = nextDay(cells);
            String key = Arrays.toString(next);
            if(!set.contains(key)){
                set.add(key);
                cycle++;
            }else{
                hasCycle=true;
                break;
            }
            cells = next;
        }
        if(hasCycle){
            N%=cycle; // We will take modulo with cycle value to find the next state.
            for(int i = 0;i<N;i++){
                cells = nextDay(cells);
            }
        }

        return cells;
    }


    private int[] nextDay (int[] cells){
        int[] tmp = new int[cells.length];
        for(int i =1;i<cells.length-1;i++){
            tmp[i] = cells[i-1] == cells[i+1]?1:0;
        }
        return tmp;
    }
}
