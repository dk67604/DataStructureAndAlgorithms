package main.java.datastructure;

import java.util.concurrent.locks.ReentrantLock;

public class MyCircularQueue {
    private int[] queue;
    private int headIndex;
    private int count;
    private int capacity;
    // Additional variable to secure the access of our queue
    private ReentrantLock queueLock = new ReentrantLock();
    /**
     * Initialize your data structure
     */
    public MyCircularQueue(int k){
        this.capacity = k;
        this.count=0;
        this.headIndex = 0;
        this.queue = new int[k];
    }

    /**
     * Insert as element into the circular queue. Return true if the operation is successful
     */
    public boolean enQueue(int value){

        if(this.count == this.capacity)
            return false;
        this.queue[(this.headIndex + this.count)%this.capacity] = value;
        this.count+=1;
        return true;
    }

    /**
     * Delete an element from the circular queue.Return true if the operation is successful
     */
    public boolean deQueue(){
        if(this.count == 0)
            return false;
        this.headIndex = (this.headIndex +1) % this.capacity;
        this.count-=1;
        return true;
    }

    /**
     * Get the front item from the queue
     */
    public int Front(){
        if(this.count == 0)
            return -1;
        return this.queue[this.headIndex];
    }

    /**
     * Get the last item from the queue
     */
    public int Rear(){
        if(this.count ==0)
            return -1;
        int tailIndex = (this.headIndex+this.count-1)%this.capacity;
        return this.queue[tailIndex];
    }

    /**
     * Check whether the circular queue is empty or not
     */
    public boolean isEmpty(){
        return (this.count == 0);
    }

    /**
     * Check whether the circular array is full or not
     */
    public boolean isFull(){
        return (this.count == this.capacity);
    }
}
