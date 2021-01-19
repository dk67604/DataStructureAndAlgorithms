package main.java.systemdesign;
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
/*
Instead of only storing the next value after we've peeked at it, we can store it immediately in the constructor and then again in the next(...) method. This greatly simplifies the code, because we no longer need conditionals to check whether or not we are currently storing a peeked at value.
*/
import java.util.Iterator;
import java.util.NoSuchElementException;
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iter;
    private Integer next = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        // Avoid an exception being thrown in constructor
        if(iterator.hasNext()){
            next = iterator.next(); // save immediately the peek
        }
        iter = iterator;

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(next == null){
            throw new NoSuchElementException();
        }
        Integer toReturn = next;
        next = null;
        if(iter.hasNext()){
            next = iter.next(); // Update the peek with new value
        }
        return toReturn;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}