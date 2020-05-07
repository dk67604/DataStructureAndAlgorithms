package main.java.leetcode;

public class DSU {
    int [] parent;
    int[] rank;
    public DSU(int size) {
        parent = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;

        }
        rank = new int[size];
    }
    public int find(int x){
        if(parent[x]!=x) parent[x] = find(parent[x]); // Path Compression
        return parent[x];
    }
    public void union(int x,int y){
        // parent[find(x] = find(y); //Union without rank;
        int xr = find(x), yr = find(y);
        if (rank[xr] < rank[yr]) {
            parent[xr] = yr;
        } else if (rank[xr] > rank[yr]) {
            parent[yr] = xr;
        } else {
            parent[yr] = xr;
            rank[xr]++;
        }
    }

    public boolean checkUnion(int x, int y) {
        int xr = find(x), yr = find(y);
        if (xr == yr) {
            return false;
        } else if (rank[xr] < rank[yr]) {
            parent[xr] = yr;
        } else if (rank[xr] > rank[yr]) {
            parent[yr] = xr;
        } else {
            parent[yr] = xr;
            rank[xr]++;
        }
        return true;
    }
}
