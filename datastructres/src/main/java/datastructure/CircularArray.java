package main.java.datastructure;

import java.util.Iterator;

public class CircularArray<T> implements Iterable<T> {
    private final T[] items;
    private int head = 0;

    public CircularArray(int size) {
        items = (T[]) new Object[size];
    }

    public static void main(String[] args) {
        int size = 10;
        CircularArray<String> array = new CircularArray<String>(size);
        for (int i = 0; i < size; i++) {
            array.set(i, String.valueOf(i));
        }

        array.rotate(3);
        for (int i = 0; i < size; i++) {
            System.out.println(array.get(i));
        }

        System.out.println();

        array.rotate(2);
        for (String s : array) {
            System.out.println(s);
        }
    }

    private int convert(int index) {
        if (index < 0) {
            index += items.length;
        }
        return (head + index) % items.length;
    }

    public void rotate(int shiftRight) {
        head = convert(shiftRight);
    }

    public T get(int i) {
        if (i < 0 || i >= items.length) {
            throw new IndexOutOfBoundsException("Index " + i + " is out of bound");
        }
        return items[convert(i)];
    }

    public void set(int i, T item) {
        items[convert(i)] = item;
    }

    public Iterator<T> iterator() {
        return new CircularArrayIterator();
    }

    private class CircularArrayIterator implements Iterator<T> {
        private int _current = -1;

        public CircularArrayIterator() {

        }

        @Override
        public boolean hasNext() {
            return _current < items.length - 1;
        }

        @Override
        public T next() {
            _current++;
            return items[convert(_current)];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove is not supported bu Circular Array");
        }
    }
}
