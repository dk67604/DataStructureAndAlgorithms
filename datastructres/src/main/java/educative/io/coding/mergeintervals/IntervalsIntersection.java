package main.java.educative.io.coding.mergeintervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalsIntersection {
    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> result = new ArrayList<>();
        int i =0, j=0;
        while (i<arr1.length && j<arr2.length){
            //check if there is an overlap between the array's interval
            if((arr1[i].start>= arr2[j].start && arr1[i].start<= arr2[j].end)
                    ||(arr2[j].start >= arr1[i].start && arr2[j].start <= arr1[i].end)){
                //Find the overlapping interval
                result.add(new Interval(Math.max(arr1[i].start,arr2[j].start),Math.min(arr1[i].end,arr2[j].end)));
            }
            //move next from the interval which is finished first
            if(arr1[i].end < arr2[j].end){
                i++;
            }
            else {
                j++;
            }
        }
        return result.toArray(new Interval[result.size()]);
    }

    public static void main(String[] args) {
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        Interval[] result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        input2 = new Interval[] { new Interval(5, 10) };
        result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }

    }
