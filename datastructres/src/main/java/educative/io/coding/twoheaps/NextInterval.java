package main.java.educative.io.coding.twoheaps;

import java.util.PriorityQueue;

class Interval {
    int start = 0;
    int end = 0;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class NextInterval {
    public static int[] findNextInterval(Interval[] intervals) {
        int n = intervals.length;
        // heap for finding the maximum start
        PriorityQueue<Integer> maxStartHeap = new PriorityQueue<>(n, (i1, i2) -> intervals[i2].start - intervals[i1].start);
        // heap for finding the minimum end
        PriorityQueue<Integer> maxEndHeap = new PriorityQueue<>(n, (i1, i2) -> intervals[i2].end - intervals[i1].end);
        int[] result = new int[n];
        for (int i = 0; i < intervals.length; i++) {
            maxStartHeap.offer(i);
            maxEndHeap.offer(i);
        }

        // go through all the intervals to find each interval's next interval
        for (int i = 0; i < n; i++) {
            int topEnd = maxEndHeap.poll(); // let's find the next interval of the interval which has the highest 'end'
            result[topEnd] = -1; // defaults to -1
            if (intervals[maxStartHeap.peek()].start >= intervals[topEnd].end) {
                int topStart = maxStartHeap.poll();
                // find the the interval that has the closest 'start'
                while (!maxStartHeap.isEmpty() && intervals[maxStartHeap.peek()].start >= intervals[topEnd].end) {
                    topStart = maxStartHeap.poll();
                }
                result[topEnd] = topStart;
                maxStartHeap.add(topStart); // put the interval back as it could be the next interval of other intervals
            }
        }
        return result;
    }
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        Interval[] intervalsList = new Interval[intervals.length];
        for(int i = 0; i<intervals.length; i++){
            intervalsList[i] = new Interval(intervals[i][0],intervals[i][1]);
        }
        PriorityQueue<Integer> maxStartHeap = new PriorityQueue<>(n, (i1,i2) -> intervalsList[i2].start - intervalsList[i1].start);
        PriorityQueue<Integer> maxEndHeap = new PriorityQueue<>(n, (i1,i2) -> intervalsList[i2].end - intervalsList[i1].end);
        int[] result = new int[n];
        for(int i = 0 ; i<n; i++){
            maxStartHeap.offer(i);
            maxEndHeap.offer(i);
        }

        for(int i =0; i<n;i++){
            int topEnd = maxEndHeap.poll();
            result[topEnd] = -1;
            if(intervalsList[maxStartHeap.peek()].start >= intervalsList[topEnd].end){
                int topStart = maxStartHeap.poll();
                while(!maxStartHeap.isEmpty() && (intervalsList[maxStartHeap.peek()].start >= intervalsList[topEnd].end)){
                    topStart = maxStartHeap.poll();
                }
                result[topEnd] = topStart;
                maxStartHeap.add(topStart);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[] { new Interval(3, 4), new Interval(2, 3), new Interval(5, 6) };
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
