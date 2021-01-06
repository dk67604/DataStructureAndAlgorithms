package main.java.leetcode;


import java.util.*;


public class NodesInSubTree {
    static class TreeNode {

        // Tree Node
        static class Node {
            public int val;
            public List<Node> children;

            public Node() {
                val = 0;
                children = new ArrayList<Node>();
            }

            public Node(int _val) {
                val = _val;
                children = new ArrayList<Node>();
            }

            public Node(int _val, ArrayList<Node> _children) {
                val = _val;
                children = _children;
            }
        }

       static class Query {
            int u;
            char c;

            Query(int u, char c) {
                this.u = u;
                this.c = c;
            }
        }
    }

   static int[] countOfNodes(TreeNode.Node root, ArrayList<TreeNode.Query> queries, String s) {
        if(root == null ) return new int[]{0}; // Return an empty array
        Map<Character,Integer> indexLookup;
        List<Integer> ans = new ArrayList<>();
        for(TreeNode.Query query : queries){
            int v = query.u;
            char c = query.c;
            TreeNode.Node curr = null;
            indexLookup = new HashMap<>();
            if(root.val != v){ //If root is not in target query
                for(TreeNode.Node child : root.children){
                    if(child.val == v){
                        curr = child;
                    }
                }
            }
            else {
                curr = root;
            }

            if(curr != null){
                dfs(curr,indexLookup,c,s);
            }
            if(!indexLookup.isEmpty()){
                ans.add(indexLookup.get(c));
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
    private static void  dfs(TreeNode.Node curr, Map<Character,Integer> indexLookup, char c,String s){
        if(curr == null){
            return;
        }
        if(s.charAt(curr.val-1) == c){
            indexLookup.put(c,indexLookup.getOrDefault(c,0) +1);
        }
        for(TreeNode.Node child : curr.children){
            dfs(child,indexLookup,c,s);
        }
        return;
    }

    public static void main(String[] args) {
        int n_2 = 7, q_2 = 3;
        String s_2 = "abaacab";
        TreeNode.Node root_2 = new TreeNode.Node(1);
            root_2.children.add(new TreeNode.Node(2));
        root_2.children.add(new TreeNode.Node(3));
        root_2.children.add(new TreeNode.Node(7));
        root_2.children.get(0).children.add(new TreeNode.Node(4));
        root_2.children.get(0).children.add(new TreeNode.Node(5));
        root_2.children.get(1).children.add(new TreeNode.Node(6));
        ArrayList<TreeNode.Query> queries_2 = new ArrayList<>();
        queries_2.add(new TreeNode.Query(1, 'a'));
        queries_2.add(new TreeNode.Query(2, 'b'));
        queries_2.add(new TreeNode.Query(3, 'a'));
        int[] output_2 = countOfNodes(root_2, queries_2, s_2);
        System.out.println(Arrays.toString(output_2));
    }

}

