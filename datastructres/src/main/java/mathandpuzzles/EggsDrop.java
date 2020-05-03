package main.java.mathandpuzzles;

/*
* 6.8 The Egg Drop Problem: There is a building of 100 floors. If an egg drops from the Nth floor or
above, it will break. If it's dropped from any floor below, it will not break.
You're given two eggs. Find N, while minimizing the number of drops for the worst case.
* */

public class EggsDrop {
    public int solveEggdrop(int noOfFloors,int noOfEggs){
        //Stores the number of tries for given floor and egg
        int[][] lookup = new int[noOfFloors+1][noOfEggs+1];
        for (int i=1;i<noOfFloors+1;i++){
            lookup[i][1] = i;
        }
        for (int i=1;i<noOfEggs+1;i++){
            lookup[1][i] = 1;
        }
        for(int i=2;i<noOfFloors+1;i++){
            for (int j=2;j<noOfEggs+1;j++){
                lookup[i][j] = Integer.MAX_VALUE;
                for (int x=1;x<i;x++){ // Summation of recurrence relation
                    //The part of recurrence relation which represents at floor x the egg is broke
                    // so anything below x will break the egg, with no. of eggs decreased by 1
                    int brokenEggResult = lookup[x-1][j-1];
                    //The part of recurrence relation which represents at floor x the is not broken,
                    // so at this point we are left with remaining floor keeping the egg count same.
                    int survivedEggs = lookup[i-x][j];
                    // To get the worst-case scenario we will maximize among two scenario,
                    //also keep into account at floor x when we throw, the try given should be added
                    int temp = Math.max(brokenEggResult,survivedEggs)+1;
                    // For all possible such x value of floor, minimize the number of tries
                    lookup[i][j] = Math.min(temp,lookup[i][j]);
                }
            }
        }
        return lookup[noOfFloors][noOfEggs];
    }

    public static void main(String[] args) {
        EggsDrop eggsDrop = new EggsDrop();
        int[] noOfFloorsTests = {100,8};
        int[] noOfEggsTests = {2,4};
        for (int i = 0; i<noOfEggsTests.length;i++){
            System.out.println("Minimum number of drops for worst case:"+eggsDrop.solveEggdrop(noOfFloorsTests[i],noOfEggsTests[i]));
        }
    }
}


