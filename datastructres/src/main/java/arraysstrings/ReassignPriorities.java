package main.java.arraysstrings;

import java.util.*;

public class ReassignPriorities {
    public static List<Integer> reassignPriorities(List<Integer> priorities) {
        Set<Integer> unique = new TreeSet<>(priorities);
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> priorityLookup = new HashMap<>();
        int priority = 1;
        for (int number : unique) {
            priorityLookup.put(number, priority++);
        }
        for (int number : priorities) {
            result.add(priorityLookup.get(number));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> priorities = Arrays.asList(2, 9, 3, 2, 3);
        System.out.println(reassignPriorities(priorities));
        priorities = Arrays.asList(1, 3, 7, 3);
        System.out.println(reassignPriorities(priorities));
    }
}
