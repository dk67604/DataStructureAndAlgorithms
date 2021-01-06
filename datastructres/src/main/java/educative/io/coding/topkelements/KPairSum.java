package main.java.educative.io.coding.topkelements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;



class KPairSum {
    class Entry{
        int p1;
        int p2;
        int col;

        public Entry(int p1,int p2,int col){
            this.p1 = p1;
            this.p2 = p2;
            this.col = col;
        }
        public int getSum(){
            return p1+p2;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>((e1, e2) -> e1.getSum() - e2.getSum());
        for(int i =0; i< Math.min(nums1.length,k);i++){
            minHeap.add(new Entry(nums1[i],nums2[0],0));
        }

        List<List<Integer>> result = new ArrayList<>();
        while( k-- > 0 && !minHeap.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            Entry entry = minHeap.poll();
            temp.add(entry.p1);
            temp.add(entry.p2);
            result.add(temp);
            if(entry.col == nums2.length - 1) continue;
            minHeap.offer(new Entry(entry.p1,nums2[entry.col+1],entry.col+1));
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k =3;
        KPairSum kPairSum = new KPairSum();
        System.out.println(kPairSum.kSmallestPairs(nums1,nums2,k));
    }
}