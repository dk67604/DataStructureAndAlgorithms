package main.java.leetcode.nary_tree;

import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/discuss/1367273/n-ary-tree-for-lca
class TreeNode{
    int val;
    List<TreeNode> children;
    public TreeNode(int val){
        this.val = val;
    }
}
public class NAryLCA {


    public TreeNode findLCA(TreeNode root, TreeNode src, TreeNode dst) {
        if (root == null || root == src || root == dst) return root;
        if (root.children == null || root.children.size() == 0) return null;
        int count = 0;
        TreeNode res = null;
        for (TreeNode child : root.children) {
            TreeNode cur = findLCA(child, src, dst);
            if (cur != null) {
                count++;
                res = cur;
            }
        }
        if (count == 2) return root;
        return res;
    }


    public int dist(TreeNode p,TreeNode c,int h){
        if(p == c){
            return h;
        }
        else if(p==null) return Integer.MIN_VALUE;
        else if(p.children == null || p.children.size() == 0) return Integer.MIN_VALUE;
        for (TreeNode node: p.children){
            int d = dist(node,c,h+1);
            if(d!=Integer.MIN_VALUE){
                return d;
            }
        }
        return Integer.MIN_VALUE;
    }
    public  int findDist(TreeNode root, TreeNode src, TreeNode dst) {
        TreeNode lca = findLCA(root, src, dst);
        return dist(lca, src, 0) + dist(lca, dst, 0);
    }
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        TreeNode r1 = new TreeNode(5);
        TreeNode r2 = new TreeNode(1);
        TreeNode r3 = new TreeNode(2);
        List<TreeNode> c1 = Arrays.asList(new TreeNode[]{r2, r3});
        r1.children = c1;

        TreeNode r4 = new TreeNode(6);
        TreeNode r5 = new TreeNode(8);
        TreeNode r6 = new TreeNode(18);
        List<TreeNode> c3 = Arrays.asList(new TreeNode[]{r4, r5, r6});
        r3.children = c3;

        TreeNode r7 = new TreeNode(10);
        List<TreeNode> c4 =  Arrays.asList(new TreeNode[]{r7});
        r4.children = c4;
        NAryLCA nAryLCA = new NAryLCA();
        TreeNode res = nAryLCA.findLCA(r1, r7, r6);
        System.out.println(res.val);
        System.out.println(nAryLCA.findDist(r1,r7,r6));
    }

}
