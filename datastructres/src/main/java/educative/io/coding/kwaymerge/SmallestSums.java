package main.java.educative.io.coding.kwaymerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((p1, p2) -> p2[0] + p2[1] - (p1[0]+p1[1]));
        for(int i = 0; i< nums1.length && i<k; i++){
            for(int j =0; j< nums2.length && j<k; j++){
                if(maxHeap.size() < k){
                    maxHeap.add(new int[]{nums1[i],nums2[j]});
                }
                else{
                    // if the sum of the two numbers from the two arrays is greater than the smallest (top) element of
                    // the heap, we can 'break' here. Since the arrays are sorted in the ascending order, we'll not be
                    // able to find a pair with a higher sum moving forward.
                    if(nums1[i] + nums2[j] > maxHeap.peek()[0] + maxHeap.peek()[1])
                        break;
                    else {// else: we have a pair with a larger sum, remove top and insert this pair in the heap
                        maxHeap.poll();
                        maxHeap.add(new int[]{nums1[i],nums2[j]});
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while (!maxHeap.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int[] entry = maxHeap.poll();
            temp.add(entry[0]);
            temp.add(entry[1]);
            result.add(temp);
        }
        return result;
    }
}
