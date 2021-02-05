package main.java.leetcode;

public class BSTKeyInGivenRange {

    public static void rangeTraversal(TreeNode root, int n1, int n2) {
        if (root == null) {
            return;
        }
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                // check if current node
                // lies between n1 and n2
                if (curr.val <= n2 && curr.val >= n1) {
                    System.out.print(curr.val + " ");
                }
                curr = curr.right;
            } else {
                TreeNode pre = curr.left;
                // finding the inorder predecessor-
                // inorder predecessor is the right
                // most in left subtree or the left
                // child, i.e in BST it is the
                // maximum(right most) in left subtree.
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }
                //threaded binary tree
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;

                } else {
                    pre.right = null;
                    // check if current node lies
                    // between n1 and n2
                    if (curr.val <= n2 && curr.val >= n1) {
                        System.out.print(curr.val + " ");
                    }
                    curr = curr.right;
                }

            }
        }
    }

    // Driver Code
    public static void main(String[] args) {
  
    /* Constructed binary tree is  
        4  
        / \  
    2     7  
    / \ / \  
    1 3 6 10  
*/

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);

        rangeTraversal(root, 4, 12);

    }
}
