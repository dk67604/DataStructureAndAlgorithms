package main.java.careercup;

import java.util.*;

/*
Given a binary tree of numbers and a search number has given,
find out first occurence of that number and smallest distance from root node.
if you have given k search numbers find their occurence and nearest from root node in a single walk.
 */
public class P1 {


    public static void main(String[] args) {
        Node head = new Node(6);
        head.left = new Node(2);
        head.right = new Node(5);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(4);
        head.left.left.left = new Node(1);
        int[] arr = new int[]{1, 5};
        P1 p1 = new P1();
        System.out.println(Arrays.toString(p1.getDistanceFromRoot(head, arr)));

    }

    public int[] getDistanceFromRoot(Node head, int[] arr) {
        int[] result = new int[arr.length];
        Arrays.fill(result, -1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < arr.length; j++) {
            map.putIfAbsent(arr[j], j);
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node temp = queue.poll();
                if (map.containsKey(temp.val) && result[map.get(temp.val)] == -1) {
                    result[map.get(temp.val)] = level;
                }
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
                size--;
            }
            level++;
        }
        return result;
    }
}
