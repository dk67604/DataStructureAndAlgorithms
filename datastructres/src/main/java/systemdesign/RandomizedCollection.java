package main.java.systemdesign;

import java.util.*;

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
public class RandomizedCollection {
    ArrayList<Integer> lst;
    Map<Integer, Set<Integer>> idx;
    Random rand = new Random();

    public RandomizedCollection() {
        lst = new ArrayList<>();
        idx = new HashMap<>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (!idx.containsKey(val)) idx.put(val, new LinkedHashSet<>());
        idx.get(val).add(lst.size());
        lst.add(val);
        return idx.get(val).size() == 1;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!idx.containsKey(val) || idx.get(val).size() == 0) return false;
        int remove_idx = idx.get(val).iterator().next();
        idx.get(val).remove(remove_idx);
        if (remove_idx < lst.size() - 1) {
            int last = lst.get(lst.size() - 1);
            lst.set(remove_idx, last);

            idx.get(last).remove(lst.size() - 1);
            idx.get(last).add(remove_idx);
        }

        lst.remove(lst.size() - 1);
        if (idx.get(val).isEmpty()) {
            idx.remove(val);
        }

        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return lst.get(rand.nextInt(lst.size()));
    }

}
