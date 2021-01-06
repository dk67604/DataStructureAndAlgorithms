package main.java.leetcode;

import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        Map<String , PriorityQueue<String>> targest = new HashMap<>();
        // Build adjacency list
        for(String [] ticket : tickets){
            targest.computeIfAbsent(ticket[0],k -> new PriorityQueue<>()).add(ticket[1]);
        }
        List<String> route = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.isEmpty()){
            while (targest.containsKey(stack.peek()) && !targest.get(stack.peek()).isEmpty()){
                stack.push(targest.get(stack.peek()).poll());
            }
            route.add(0,stack.pop());
        }
        return route;
    }
}
