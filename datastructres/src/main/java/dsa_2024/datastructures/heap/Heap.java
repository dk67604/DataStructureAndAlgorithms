package main.java.dsa_2024.datastructures.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    List<Integer> heap;

    public Heap(){
        heap = new ArrayList<Integer>();
        heap.add(0);
    }

    public void push(int val){
        heap.add(val);
        int i = heap.size() - 1;
        // Precolate up
        // Keep moving up, if parent is bigger then child
        while (i > 1 && heap.get(i) < heap.get(i/2)) {
            int tmp = heap.get(i);
            heap.set(i, heap.get(i /2));
            heap.set(i/2, tmp);
            i = i /2;
        }
    }

    public int pop(){
        if (heap.size() == 1){
            throw new IllegalStateException("Heap is Empty ");
        }
        if (heap.size() == 2){
            return heap.remove(heap.size() - 1);
        }
        int res = heap.get(1);
        // Move the last value to root;
        heap.set(1, heap.remove(heap.size()-1));
        int i =1;
        // Precolate Down
        while (2 * i < heap.size()) {
            if( 2 * i + 1 < heap.size() &&
            heap.get(2*i + 1) < heap.get( 2* i) &&
            heap.get(i) > heap.get(2*i + 1)
            ){
                // Swap Right Child
                int tmp = heap.get(i);
                heap.set(i, heap.get(2*i + 1));
                heap.set(2*i+1, tmp);
                i = 2 * i + 1;
            }else if( heap.get(i) > heap.get(2 * i)){
                // Swap the left child
                int tmp = heap.get(i);
                heap.set(i, heap.get(2 * i));
                heap.set(2 * i ,  tmp);
                i = 2 *i;
            }else{
                break;
            }
        }
        return res;
    }

    public void heapify(ArrayList<Integer> arr) {
        // 0-th position is moved to the end
        arr.add(arr.get(0));

        heap = arr;
        int cur = (heap.size() - 1) / 2;
        while (cur > 0) {
            // Percolate Down
            int i = cur;
            while (2 * i < heap.size()) {
                if (2 * i + 1 < heap.size() &&
                heap.get(2 * i + 1) < heap.get(2 * i) &&
                heap.get(i) > heap.get(2 * i + 1)) {
                    // Swap right child
                    int tmp = heap.get(i);
                    heap.set(i, heap.get(2 * i + 1));
                    heap.set(2 * i + 1, tmp);
                    i = 2 * i + 1;
                } else if (heap.get(i) > heap.get(2 * i)) {
                    // Swap left child
                    int tmp = heap.get(i);
                    heap.set(i, heap.get(2 * i));
                    heap.set(2 * i, tmp);
                    i = 2 * i;
                } else {
                    break;
                }
            }
            cur--;
        }
        return;
    }


    public static void main(String[] args) {
        int[] nums = {14, 17, 16, 21, 19, 19, 68, 30, 26};
        Heap heap = new Heap();
        for (int num : nums){
            heap.push(num);
        }
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
    }
}
