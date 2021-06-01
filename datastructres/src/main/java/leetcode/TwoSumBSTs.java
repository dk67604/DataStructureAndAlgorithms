package main.java.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
Do iterative inorder traversal of the first tree to build hashset of complements (target - val).

Do iterative inorder traversal of the second tree to check if at least one element of the second tree is in hashset. Stop the traversal and return True once you find such an element.

We are here because tree2 doesn't contain any complement. Return False.
 */
public class TwoSumBSTs {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Stack<TreeNode> stack = new Stack<>();
        Set<Integer> s = new HashSet<Integer>();
        // traverse the first tree
        // and store node complements (target - val) in hashset
        while (!stack.isEmpty() || root1 != null) {
            while (root1 != null) {
                stack.push(root1);
                root1 = root1.left;
            }
            root1 = stack.pop();
            s.add(target - root1.val);
            root1 = root1.right;
        }

        // traverse the second tree
        // and check if one of the values exists in hashset
        while (!stack.isEmpty() || root2 != null) {
            while (root2 != null) {
                stack.push(root2);
                root2 = root2.left;
            }
            root2 = stack.pop();
            if (s.contains(root2.val)) {
                return true;
            }
            root2 = root2.right;
        }
        return false;
    }

}
