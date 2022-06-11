package main.java.topcodingquestion.treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/path-sum-ii/
public class PathWithSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<Integer>(), root, targetSum);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> currentList, TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        currentList.add(node.val);
        if (node.left == null && node.right == null && (sum - node.val) == 0) {
            result.add(new LinkedList<Integer>(currentList));
            currentList.remove(currentList.size() - 1);//backtrack
            return;
        } else {
            helper(result, currentList, node.left, sum - node.val);
            helper(result, currentList, node.right, sum - node.val);
        }
        currentList.remove(currentList.size() - 1);
    }

    // https://leetcode.com/problems/path-sum-iii/
    public int pathSumIII(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return helperIII(root, targetSum) + pathSumIII(root.left, targetSum) + pathSumIII(root.right, targetSum);
    }

    private int helperIII(TreeNode root, int sum) {
        int result = 0;
        if (root == null) {
            return result;
        }
        if (sum - root.val == 0) {
            result++;
        }
        result += helperIII(root.left, sum - root.val);
        result += helperIII(root.right, sum - root.val);
        return result;
    }
}
