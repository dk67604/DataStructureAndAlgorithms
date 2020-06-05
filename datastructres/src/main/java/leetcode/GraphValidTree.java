package main.java.leetcode;

public class GraphValidTree {

    private int findParent(int [] roots,int id){
        while (roots[id]!=id){
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }

    public boolean validTree(int n, int[][] edges) {
        //Fist criteria for validity of tree
        if(edges.length!=n-1) return false;
        int [] roots = new int[n];
        for (int i =0;i<n;i++){
            roots[i] =i;
        }

        for (int[] edge:edges){
            int root1 = findParent(roots,edge[0]);
            int root2 = findParent(roots,edge[1]);
            if(root1 == root2) return false;
            roots[root1] =root2;
        }
        return true;
    }
}
