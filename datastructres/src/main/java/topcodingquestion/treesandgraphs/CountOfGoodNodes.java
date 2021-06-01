package main.java.topcodingquestion.treesandgraphs;

import java.util.LinkedList;
import java.util.Queue;

public class CountOfGoodNodes {
    public int goodNodesII(TreeNode root) {
        Queue<TreeNodePair> queue = new LinkedList<>();
        int ans = 0;
        queue.add(new TreeNodePair(root, Integer.MIN_VALUE));
        while (!queue.isEmpty()) {
            TreeNodePair tp = queue.poll();
            if (tp.node.val >= tp.val) {
                ans += 1;
            }

            if (tp.node.left != null) {
                queue.add(new TreeNodePair(tp.node.left, Math.max(tp.val, tp.node.val)));
            }
            if (tp.node.right != null) {
                queue.add(new TreeNodePair(tp.node.right, Math.max(tp.val, tp.node.val)));
            }
        }
        return ans;
    }

    public int goodNodesI(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] count = new int[1];
        return helper(root, Integer.MIN_VALUE, count);
    }

    private int helper(TreeNode tree, int max, int[] count) {
        if (tree == null) {
            return 0;
        }
        count[0] = tree.val >= max ? 1 : 0;
        count[0] += helper(tree.left, Math.max(max, tree.val), count);
        count[0] += helper(tree.right, Math.max(max, tree.val), count);

        return count[0];

    }

    class TreeNodePair {
        TreeNode node;
        int val;

        TreeNodePair(TreeNode node, int val) {
            this.node = node;
            this.val = val;//track of maxval till parent node
        }
    }
}
