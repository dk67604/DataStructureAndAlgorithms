package main.java.topcodingquestion.treesandgraphs;

import java.util.*;

public class AllNodesAtDistanceK {
    Map<TreeNode, TreeNode> parentLookup;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parentLookup = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        dfs(root, null);
        queue.add(null);//Add parent first
        queue.add(target);
        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);
        seen.add(null);
        int dist = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            {
                if (node == null) {
                    if (dist == K) {
                        List<Integer> result = new ArrayList<>();
                        for (TreeNode n : queue) {
                            result.add(n.val);
                        }
                        return result;
                    }
                    queue.add(null);
                    dist++;
                } else {
                    if (!seen.contains(node.left)) {
                        queue.add(node.left);
                        seen.add(node.left);
                    }
                    if (!seen.contains(node.right)) {
                        queue.add(node.right);
                        seen.add(node.right);
                    }
                    TreeNode par = parentLookup.get(node);
                    if (!seen.contains(par)) {
                        queue.add(par);
                        seen.add(par);
                    }
                }
            }
        }
        return new ArrayList<Integer>();
    }

    private void dfs(TreeNode node, TreeNode parent) {
        if (node != null) {
            parentLookup.put(node, parent);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}
