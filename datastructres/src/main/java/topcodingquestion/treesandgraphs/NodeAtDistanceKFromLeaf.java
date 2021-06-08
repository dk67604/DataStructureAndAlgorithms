package main.java.topcodingquestion.treesandgraphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NodeAtDistanceKFromLeaf {
    public static void main(String[] args) {
        NodeAtDistanceKFromLeaf nodeAtDistanceKFromLeaf = new NodeAtDistanceKFromLeaf();
        nodeAtDistanceKFromLeaf.leafNodeDistance(TreeNode.getSampleTree(), 1);
    }

    public void leafNodeDistance(TreeNode node, int dist) {
        // list to store root-to-leaf path
        List<TreeNode> path = new ArrayList<>();
        // create an empty set to store distinct nodes at a given
        // distance from leaf nodes
        Set<TreeNode> set = new HashSet<>();
        leafNodeDistance(node, path, set, dist);
        for (TreeNode t : set)
            System.out.println(t.val);
    }

    private void leafNodeDistance(TreeNode node, List<TreeNode> path, Set<TreeNode> set,
                                  int dist) {
        if (node == null) {
            return;
        }
        // if a leaf node is found, insert the node at a distance `dist` from the
        // leaf node into the set
        if (isLeaf(node) && path.size() >= dist) {
            set.add(path.get(path.size() - dist));
            return;
        }
        // include the current node in the current path
        path.add(node);
        // recur for the left and right subtree
        leafNodeDistance(node.left, path, set, dist);
        leafNodeDistance(node.right, path, set, dist);
        // remove the current node from the current path
        path.remove(node);

    }

    private boolean isLeaf(TreeNode treeNode) {
        return treeNode.left == null && treeNode.right == null;
    }
}
