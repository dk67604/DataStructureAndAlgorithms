package main.java.binarysearch;

public class BillionUserDay {

    private double getUserOnDay(float rate, int day){
        return Math.pow(rate,day);
    }

    public int getBillionUsersDay(float[] growthRates) {
        int start = 1;
        int end = 2000;
        double target = 1_000_000_000;
        while (start < end){
            double total = 0;
            int mid = start + (end - start)/2;
            for( float rate : growthRates){
                total+= getUserOnDay(rate,mid);
            }
            if(total == target){
                return mid;
            }
            if(total < target){
                start = mid +1;
            }
            else {
                end = mid;
            }
        }
        return start;
    }
}
