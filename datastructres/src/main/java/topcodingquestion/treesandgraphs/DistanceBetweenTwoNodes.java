package main.java.topcodingquestion.treesandgraphs;


class DistanceBetweenTwoNodes {
    // Helper function to check if a given node is present in a binary tree or not
    private static boolean isTreeNodePresent(TreeNode root, TreeNode node) {
        //base case
        if (root == null)
            return false;
        // return true if the node is found in the left or right subtree

        if (root == node)
            return true;
        // return true if the node is found in the left or right subtree

        return isTreeNodePresent(root.left, node) || isTreeNodePresent(root.right, node);
    }

    private static int findLevel(TreeNode root, TreeNode node, int level) {
        // base case
        if (root == null)
            return Integer.MIN_VALUE;
        if (root == node)
            return level;
        // search node in the left subtree
        int left = findLevel(root.left, node, level + 1);
        // if the node is found in the left subtree, return the left pointer
        if (left != Integer.MIN_VALUE)
            return left;
        // otherwise, continue the search in the right subtree
        return findLevel(root.right, node, level + 1);
    }

    // Function to find the lowest common ancestor of given nodes `x` and `y`,
    // where both `x` and `y` are present in the binary tree.
    private static TreeNode findLCA(TreeNode root, TreeNode x, TreeNode y) {
        // base case 1: if the tree is empty
        if (root == null) {
            return null;
        }
        // base case 2: if either 'x' and 'y' is found
        if (root == x || root == y)
            return root;
        // recursively check if `x` or `y` exists in the left subtree
        TreeNode left = findLCA(root.left, x, y);
        // recursively check if `x` or `y` exists in the right subtree
        TreeNode right = findLCA(root.right, x, y);
        // if `x` is found in one subtree and `y` is found in the other subtree,
        // update lca to the current node
        if (left != null && right != null)
            return root;

        // if `x` and `y` exist in the left subtree
        if (left != null)
            return left;
        // if `x` and `y` exist in the right subtree
        return right;
    }

    // Function to find the distance between node `x` and node `y` in a
    // given binary tree rooted at `root` node
    public static int findDistance(TreeNode root, TreeNode x, TreeNode y) {
        // `lca` stores the lowest common ancestor of `x` and `y`
        TreeNode lca = null;

        // call LCA procedure only if both `x` and `y` are present in the tree
        if (isTreeNodePresent(root, y) && isTreeNodePresent(root, x)) {
            lca = findLCA(root, x, y);
        } else {
            return Integer.MIN_VALUE;
        }

        // return distance of `x` from lca + distance of `y` from lca
        return findLevel(lca, x, 0) + findLevel(lca, y, 0);

        // the above statement is equivalent to
        // return findLevel(root, x, 0) + findLevel(root, y, 0) -
        //        2*findLevel(root, lca, 0);

        // can avoid calling the `isTreeNodePresent()` function by using
        // return values of the `findLevel()` function to check if
        // `x` and `y` are present in the tree or not
    }

    public static void main(String[] args) {
        /* Construct the following tree
              1
            /   \
           /     \
          2       3
           \     / \
            4   5   6
               / \
              7   8
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        // find the distance between node 7 and node 6
        System.out.print(findDistance(root, root.right.left.left, root.right.right));
    }
}