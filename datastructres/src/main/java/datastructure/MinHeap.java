package main.java.datastructure;

import java.util.Arrays;
//Reference : https://github.com/midNight-jam/DataStructures_Algorithms_Java/blob/master/src/ADT/MinHeap.java
public class MinHeap {
    //Min Heap
    private int[] heap;
    private int heapCount;
    public MinHeap(int size){
        heap = new int[size+1];
        heapCount = 0;
    }

    private void doubleSize(){
        heap = Arrays.copyOf(heap,heap.length+2);
    }

    public boolean isEmpty(){
        return heapCount ==0;
    }

    public void insert(int data){
        if(heapCount == heap.length-1){
            doubleSize();
        }
        int pos = ++heapCount;
        //checking for less than because MinHeap
        while ((pos > 1) && (data < heap[pos/2])){
            heap[pos] = heap[pos/2];
            pos = pos/2;
        }
        heap[pos] = data;
    }

    public int fetchTop(){
        int res = heap[1];
        int ptr,left,right;
        ptr =1;
        left = 2*ptr;
        right = left+1;
        heap[1] = heap[heapCount];//get the last element at the top;
        int last = heap[heapCount]; //store the last element
        while (right<=heapCount){
            //take min among two childs and than shift down the parent
            // shift down left subtree
            if (heap[left] <=heap[right]){
                heap[ptr] = heap[right];
                ptr = right;
            }
            //Shift down right sub tree
            if(heap[right] <= heap[left]){
                heap[ptr] = heap[left];
                ptr=left;
            }
            left = 2*ptr;
            right = left+2;
        }
        heap[ptr] = last;
        heapCount--;
        return res;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(6);
        minHeap.insert(2);
        minHeap.insert(7);
        minHeap.insert(6);
        minHeap.insert(10);
        minHeap.insert(8);
        minHeap.insert(20);
//        minHeap.insert(23);
        System.out.println(minHeap.fetchTop());
    }
}
