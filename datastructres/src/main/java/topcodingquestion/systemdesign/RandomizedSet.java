package main.java.topcodingquestion.systemdesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
We must support three operations with duplicates:
insert
remove
getRandom
To getRandom in O(1)O(1) and have it scale linearly with the number of copies of a value. The simplest solution is to store all values in a list. Once all values are stored, all we have to do is pick a random index.
We don't care about the order of our elements, so insert can be done in O(1)O(1) using a dynamic array (ArrayList in Java or list in Python).
The issue we run into is how to go about an O(1) remove. Generally we learn that removing an element from an array takes a place in O(N)O(N), unless it is the last element in which case it is O(1)O(1).
The key here is that we don't care about order. For the purposes of this problem, if we want to remove the element at the ith index, we can simply swap the ith element and the last element, and perform an O(1)O(1) pop (technically we don't have to swap, we just have to copy the last element into index i because it's popped anyway).
With this in mind, the most difficult part of the problem becomes finding the index of the element we have to remove. All we have to do is have an accompanying data structure that maps the element values to their index.
 */
public class RandomizedSet {
    ArrayList<Integer> list;
    Map<Integer, Integer> idx;
    Random rand = new Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        list = new ArrayList<>();
        idx = new HashMap<>();
    }

    /**
     * Insert a value to the collection. Returns true if the collection did not already contain the
     * specified element
     */
    public boolean insert(int val) {

        if (idx.containsKey(val)) return false;
        idx.put(val, list.size());
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!idx.containsKey(val)) return false;
        int remove_idx = idx.get(val);
        if (remove_idx < list.size() - 1) {
            int last = list.get(list.size() - 1);
            list.set(remove_idx, last);
            idx.put(last, remove_idx);
        }
        list.remove(list.size() - 1);
        idx.remove(val);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

}
