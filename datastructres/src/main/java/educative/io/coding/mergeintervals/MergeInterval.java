package main.java.educative.io.coding.mergeintervals;

import java.util.*;

public class MergeInterval {
    public static List<Interval> merge(List<Interval> intervals){
        if(intervals.size() <2){
            return intervals;
        }

        Collections.sort(intervals,(a,b) -> Integer.compare(a.start,b.start));
        List<Interval> mergedInterval = new LinkedList<Interval>();
        Iterator<Interval> intervalIterator = intervals.iterator();
        Interval interval = intervalIterator.next();
        int start = interval.start;
        int end = interval.end;
        while (intervalIterator.hasNext()){
            interval = intervalIterator.next();
            if(interval.start <= end){
                end = Math.max(interval.end,end);
            }else {
                mergedInterval.add(new Interval(start,end));
                start = interval.start;
                end = interval.end;
            }
        }
        mergedInterval.add(new Interval(start,end));
        return mergedInterval;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeInterval.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }

}
