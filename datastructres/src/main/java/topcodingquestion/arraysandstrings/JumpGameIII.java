package main.java.topcodingquestion.arraysandstrings;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII {
    //DFS- Time Complexity: O(N)
    public boolean canReachI(int[] arr, int start) {
        if (start < 0 || start >= arr.length || arr[start] < 0)
            return false;
        if (arr[start] == 0) return true;
        arr[start] = -arr[start];
        return canReachI(arr, start - arr[start]) || canReachI(arr, start + arr[start]);
    }

    //BFS
    public boolean canReachII(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int n = arr.length;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (arr[node] == 0) {
                return true;
            }
            if (arr[node] < 0) {
                continue;
            }
            if (node - arr[node] >= 0) {
                queue.offer(node - arr[node]);
            }
            if (node + arr[node] < n) {
                queue.offer(node + arr[node]);
            }
            arr[node] = -arr[node];
        }
        return false;
    }

}
