package main.java.leetcode.nary_tree;

import java.util.HashMap;
import java.util.Map;
class TreeNode_R {
    int key;         // or char key;
    TreeNode_R parent;
    public TreeNode_R(int key){
        this.key =key;
    }
}

public class NAryTreeBetweenTwoNodes {

    public  int findDist(TreeNode_R src, TreeNode_R dst) {
        final Map<TreeNode_R, Integer> parents = new HashMap<>();
        TreeNode_R current = src;
        int dist = 0;
        while (current != null) {
            parents.put(current, dist++);
            current = current.parent;
        }
        current = dst;
        dist = 0;
        while (!parents.containsKey(current)) {
            current = current.parent;
            dist++;
        }
        return parents.get(current) + dist;
    }

    public static void main(String[] args) {
        TreeNode_R node = new TreeNode_R(1);
        TreeNode_R node_r = new TreeNode_R(2);
        node_r.parent =node;
        TreeNode_R node_l = new TreeNode_R(3);
        node_l.parent = node;
        TreeNode_R node_k = new TreeNode_R(4);
        node_k.parent = node;
        TreeNode_R node_m = new TreeNode_R(5);
        node_m.parent = node_r;
        NAryTreeBetweenTwoNodes nAryTreeBetweenTwoNodes = new NAryTreeBetweenTwoNodes();
        System.out.println(nAryTreeBetweenTwoNodes.findDist(node_m,node_k));
    }
}
