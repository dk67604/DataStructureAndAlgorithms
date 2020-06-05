package main.java.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomII {

    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length ==0) return 0;
        //Sort the interval by start time
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        //Use min heap to track the minimum end time of merged interval
        PriorityQueue<int[]> pq = new PriorityQueue<>(intervals.length, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        pq.offer(intervals[0]);
        for (int i =1;i<intervals.length;i++){
            int[] temp = pq.poll();
            if(intervals[i][0] >=temp[1]){
                // if the current meeting starts right after
                // there's no need for a new room, merge the interval
                temp[1] = intervals[i][1];
            }else{
                // otherwise, this meeting needs a new room
                pq.offer(intervals[i]);
            }
            pq.offer(temp);
        }
        return pq.size();
    }

    public static void main(String[] args) {
        int[][] intervals = {{0, 30},{5, 10},{15, 20}};
        MeetingRoomII meetingRoomII = new MeetingRoomII();
        System.out.println(meetingRoomII.minMeetingRooms(intervals));
    }
}
