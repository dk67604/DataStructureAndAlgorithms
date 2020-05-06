package main.java.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
Given a 1-d array candy crush, return the shortest array after removing all the continuous same numbers (the repeating number >= 3)
input: 1-d array [1, 3, 3, 3, 2, 2, 2, 3, 1]
return: [1, 3,1]
Time complexity should be better than O(n²)
* */
public class CandyCrush {

    // Idea is use Stack for tracking last character and a variable lastSeet to compare the last of Stack
    public int[] removeRepeatingNumber(int [] in){
        if (in.length == 1) return in;
        int lastSeen = in[0];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(in[0]);
        for (int i = 1; i < in.length; i++) {
            while (deque.isEmpty()) {
                deque.add(in[i]);
                i++;
                lastSeen = in[i];
            }

            int last = deque.getLast();
            if (in[i] == lastSeen) {
                if (in[i] == last) {
                    deque.pollLast();
                    lastSeen = in[i];
                } else
                    i++;
            } else {
                deque.add(in[i]);
                lastSeen = in[i];
            }
        }

        int[] result = new int[deque.size()];
        int i = 0;
        while (!deque.isEmpty()) {
            result[i++] = deque.pollFirst();
        }
        return result;
    }

    public char[] removeRepeatingCharacter(char [] in){
        if (in.length == 1) return in;
        int lastSeen = in[0];
        ArrayDeque<Character> deque = new ArrayDeque<>();
        deque.add(in[0]);
        for (int i = 1; i < in.length; i++) {
            while (deque.isEmpty()) {
                deque.add(in[i]);
                i++;
                lastSeen = in[i];
            }

            int last = deque.getLast();
            if (in[i] == lastSeen) {
                if (in[i] == last) {
                    deque.pollLast();
                    lastSeen = in[i];
                } else
                    i++;
            } else {
                deque.add(in[i]);
                lastSeen = in[i];
            }
        }

        char[] result = new char[deque.size()];
        int i = 0;
        while (!deque.isEmpty()) {
            result[i++] = deque.pollFirst();
        }
        return result;
    }

    public static void main(String[] args) {
        CandyCrush candyCrush =  new CandyCrush();
        int[] nums = {1, 3, 3, 3, 2, 2, 2, 3, 1};
       // candyCrush.removeRepeatingNumber(nums);
        String s = "aaabbbacd";
        candyCrush.removeRepeatingCharacter(s.toCharArray());
    }
}
