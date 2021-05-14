package main.java.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TwoSumBST {

    static boolean findpairUtil(TreeNode root, int sum, int firstPair,
                                HashSet<Integer> set) {
        if (root == null)
            return false;

        if (findpairUtil(root.left, sum, firstPair, set))
            return true;


        if (findpairUtil(root.right, sum, firstPair, set)) return true;
        if (set.contains(sum - firstPair)) {
            System.out.println("Pair is found ("
                    + (sum - root.val) + ", "
                    + root.val + ")");
            return true;
        } else
            set.add(root.val);
        return false;
    }

    public static void main(String[] args) {
        TwoSumBST twoSumBST = new TwoSumBST();
        TreeNode root1 = new TreeNode(0);
        root1.left = new TreeNode(-10);
        root1.right = new TreeNode(10);

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(7);
        root2.left.left = new TreeNode(0);
        root2.left.right = new TreeNode(2);
        System.out.println(findpairUtil(root2, 17, 10, new HashSet<>()));
        System.out.println(twoSumBST.twoSumBSTs(root1, root2, 17));

    }

    public boolean findTarget(TreeNode root, int k, int firstPair) {
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                TreeNode node = queue.poll();
                if (set.contains(k - firstPair)) {
                    return true;
                }
                set.add(node.val);
                queue.add(node.right);
                queue.add(node.left);
            } else {
                queue.remove();
            }
        }
        return false;
    }

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int firstPair = node.val;
                if (findTarget(root2, target, firstPair)) {
                    return true;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return false;
    }

    private boolean findOtherPair(TreeNode current, int target, int firstPair, Set<Integer> set) {
        if (current == null)
            return false;
        if (findOtherPair(current.left, target, firstPair, set)) {
            return true;
        }
        if (set.contains(target - firstPair)) {
            return true;
        } else {
            set.add(current.val);
        }
        return findOtherPair(current.right, target, firstPair, set);
    }
}
