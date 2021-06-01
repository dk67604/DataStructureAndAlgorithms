package main.java.arraysstrings;

import java.util.*;

class Point {
    int number;
    int cardinality;

    Point(int number, int cardinality) {
        this.number = number;
        this.cardinality = cardinality;
    }

}

class PointComparator implements Comparator<Point> {

    @Override
    public int compare(Point o1, Point o2) {
        if (o1.cardinality == o2.cardinality) {
            return o1.number - o2.number;
        } else {
            return o1.cardinality - o2.cardinality;
        }
    }
}

public class Cardinality {
    private static int countBit(int bitVector) {
        int count = 0;
        while (bitVector > 0) {
            count += bitVector & 1;
            bitVector >>= 1; //right shift by 1
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        Cardinality cardinality = new Cardinality();
        System.out.println(cardinality.cardinalitySort(nums));
        nums = Arrays.asList(1, 2, 3, 4);
        System.out.println(cardinality.cardinalitySort(nums));
        nums = Arrays.asList(31, 15, 7, 3, 2);
        System.out.println(cardinality.cardinalitySort(nums));
    }

    public List<Integer> cardinalitySort(List<Integer> nums) {
        PriorityQueue<Point> minHeap = new PriorityQueue<>(5, new PointComparator()
        );

        for (int num : nums) {
            int cardinality = countBit(num);
            minHeap.add(new Point(num, cardinality));
        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().number);
        }
        return result;
    }

}
