package main.java.topcodingquestion.heaps;

import main.java.educative.io.coding.mergeintervals.Interval;

import java.util.PriorityQueue;

public class NextInterval {
    public static int[] findNextInterval(Interval[] intervals){
        int n = intervals.length;
        PriorityQueue<Integer> maxStartHeap = new PriorityQueue<>((i1,i2) -> intervals[i2].start - intervals[i1].start);
        PriorityQueue<Integer> maxEndHeap = new PriorityQueue<>((i1,i2) -> intervals[i2].end - intervals[i1].end);
        int[] result = new int[n];
        for(int i =0; i< n;i++){
            maxEndHeap.offer(i);
            maxStartHeap.offer(i);
        }
        // go through all the intervals to find each interval's next interval
        for(int i =0; i< n;i++){
            int topEnd = maxEndHeap.poll();
            result[topEnd] = -1;
            if(intervals[maxStartHeap.peek()].start >= intervals[topEnd].end){
                int topStart = maxStartHeap.poll();
                // find the  interval that has the closest 'start'
                while (!maxStartHeap.isEmpty() && intervals[maxStartHeap.peek()].start >= intervals[topEnd].end){
                    topStart = maxStartHeap.poll();
                }
                result[topEnd] = topStart;
                maxStartHeap.add(topStart);// put the interval back as it could be the next interval of other intervals
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(5, 6) };
        int[] result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
        System.out.println();

        intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) };
        result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
    }
}
