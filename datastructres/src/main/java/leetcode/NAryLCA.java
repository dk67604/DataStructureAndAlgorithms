package main.java.leetcode;

import java.util.List;

public class NAryLCA {
    class TreeNode{
        int val;
        List<TreeNode> children;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public TreeNode findLCA(TreeNode root, TreeNode src, TreeNode dst) {
        if(root == src || root == dst || root == null){
            return root;
        }
        TreeNode ans = null;
        for (TreeNode node:root.children){
            TreeNode lca = findLCA(node,src,dst);
            if(lca == null){
                continue;
            }
            else if(lca == src || lca == dst){
                if(ans == src || ans == dst){
                    return root;
                }
                else {
                     ans = lca;
                }
            }
            else if(lca!=src && lca!=dst ){
                return node;
            }
        }
        return ans;
    }


    public int dist(TreeNode p,TreeNode c,int h){
        if(p == c){
            return h;
        }
        else if(p==null) return Integer.MAX_VALUE;
        for (TreeNode node: p.children){
            int d = dist(node,c,h+1);
            if(d!=Integer.MAX_VALUE){
                return d;
            }
        }
        return Integer.MAX_VALUE;
    }
    public  int findDist(TreeNode root, TreeNode src, TreeNode dst) {
        TreeNode lca = findLCA(root, src, dst);
        return dist(lca, src, 0) + dist(lca, dst, 0);
    }

}
