package main.java.mathandpuzzles;

import java.util.Random;

public class Apocalypse {

    private int [] runOnFamily(){
        Random random = new Random();
        int boys =0;
        int girls =0;
        while (girls ==0){
            if (random.nextBoolean()){
                girls+=1;
            }
            else {
                boys+=1;
            }
        }
        return new int[]{girls,boys};
    }
    private double runNFamily(int n){
        int boys =0;
        int girls =0;
        for (int i=0;i<n;i++){
            int [] genders = runOnFamily();
            boys+= genders[1];
            girls+= genders[0];
        }
        return girls/(double)(boys+girls);
    }

    public static void main(String[] args) {
        Apocalypse apocalypse = new Apocalypse();
        int[] tests = {2,10,100,1000,100000};
        for (int i = 0; i<tests.length; i++){
            System.out.println("Gender ratio:"+apocalypse.runNFamily(tests[i]));
        }
    }
}
