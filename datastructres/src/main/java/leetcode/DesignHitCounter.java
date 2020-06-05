package main.java.leetcode;
/*
*O(s) s is total seconds in given time interval, in this case 300.
basic ideal is using buckets.
*1 bucket for every second because we only need to keep the recent hits info for 300 seconds.
 *  hit[] array is wrapped around by mod operation.
 *  Each hit bucket is associated with times[] bucket which record current time.
  *  If it is not current time, it means it is 300s or 600s... ago and need to reset to 1.
 */
public class DesignHitCounter {

    private int[] times;
    private int[] hits;
    public  DesignHitCounter(){
        times = new int [300]; //Store every s second for last 5 minutes
        hits = new int[300];
    }
    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        //Check if times is not current time then hits need to reset 1
        if(times[index] != timestamp){
            times[index] = timestamp;
            hits[index] =1;
        }else {
            hits[index]++;
        }
    }
    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total =0;
        for (int i =0; i< 300;i++){
            if(timestamp - times[i] < 300){
                total+= hits[i];
            }
        }
        return  total;
    }
    public static void main(String[] args) {
        DesignHitCounter designHitCounter = new DesignHitCounter();
        designHitCounter.hit(1);
        designHitCounter.hit(2);
        designHitCounter.hit(3);
        designHitCounter.hit(300);
        designHitCounter.hit(300);
        designHitCounter.hit(301);
        System.out.println(designHitCounter.getHits(301));
        designHitCounter.hit(600);
        System.out.println(designHitCounter.getHits(300));
    }

    }

