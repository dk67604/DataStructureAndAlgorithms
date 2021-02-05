package main.java.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        AllPathsFromSourceToTarget allPathsFromSourceToTarget = new AllPathsFromSourceToTarget();
        List<List<Integer>> result = allPathsFromSourceToTarget.allPathsSourceTarget(graph);
        System.out.println(result.size());
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int target = graph.length - 1;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<Integer> path = new LinkedList<>();
        path.addLast(0);

        backtrack(graph, 0, target, result, path);
        return result;
    }

    private void backtrack(int[][] graph, int currNode, int target, List<List<Integer>> result, LinkedList<Integer> path) {

        if (currNode == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        // explores the neighbour nodes one after the another
        for (int nextNode : graph[currNode]) {
            path.addLast(nextNode);
            backtrack(graph, nextNode, target, result, path);
            path.removeLast();
        }

    }
}
