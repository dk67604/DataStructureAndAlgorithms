package main.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CriticalConnectionNetworkv2 {
    int edgeIndex = 0;
    int[] to;
    int[] next;
    int[] head;
    int[] low;
    int time = -1;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        low = new int[n];
        int m = connections.size();
        to = new int[m * 2];
        head = new int[n];
        next = new int[m * 2];
        Arrays.fill(head, -1);
        Arrays.fill(next, -1);
        Arrays.fill(low, -1);

        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            addEdge(u, v);
            addEdge(v, u);
        }

        dfs(1, -1);
        return res;
    }

    private void dfs(int node, int parent) {
        if (low[node] != -1) {
            return;
        }

        int min = low[node] = ++ time;

        for (int edge = head[node]; edge != -1; edge = next[edge]) {
            int next = to[edge];

            if (low[next] == -1) {
                dfs(next, node);
                low[node] = Math.min(low[node], low[next]);

                if (low[next] > min) {
                    res.add(Arrays.asList(node, next));
                }
            } else if (next != parent) {
                low[node] = Math.min(low[node], low[next]);
            }
        }
    }

    private void addEdge(int u, int v) {
        to[edgeIndex] = v;
        next[edgeIndex] = head[u];
        head[u] = edgeIndex ++;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add( Arrays.stream(new int[]{0,1}).boxed().collect(Collectors.toList()));
        list.add( Arrays.stream(new int[]{1,2}).boxed().collect(Collectors.toList()));
        list.add( Arrays.stream(new int[]{2,0}).boxed().collect(Collectors.toList()));
        list.add( Arrays.stream(new int[]{1,3}).boxed().collect(Collectors.toList()));
        int n=4;
        CriticalConnectionNetworkv2 criticalConnectionNetworkv2 = new CriticalConnectionNetworkv2();
        System.out.println(criticalConnectionNetworkv2.criticalConnections(n,list));
    }
}
