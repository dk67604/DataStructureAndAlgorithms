package main.java.techiedelight.binarytree;

public class MaximumSumRootToLeafPath {

    // Function to calculate the maximum root-to-leaf sum in a binary tree
    public static int rootToLeafSum(Node root) {
        //base case: empty tree
        if (root == null) {
            return 0;
        }
        // calculate the maximum node-to-leaf sum for the left child
        int left = rootToLeafSum(root.left);
        // calculate the maximum node-to-leaf sum for the right child
        int right = rootToLeafSum(root.right);
        // consider the maximum sum child
        return Math.max(left, right) + root.data;
    }

    // Function to print the root-to-leaf path with a given sum in a binary tree
    public static boolean printPath(Node root, int sum) {
        //base case
        if (sum == 0) {
            return true;
        }
        //base case
        if (root == null) {
            return false;
        }
        boolean left = printPath(root.left, sum - root.data);
        boolean right = printPath(root.right, sum - root.data);
        if (left || right) {
            System.out.print(root.data + " ");
        }
        return left || right;

    }

    // Function to print maximum sum root-to-leaf path in a given binary tree
    public static void findMaxSumPath(Node root) {
        int sum = rootToLeafSum(root);
        System.out.println("The maximum sum is " + sum);
        System.out.print("The maximum sum path is ");

        printPath(root, sum);
    }

    public static void main(String[] args) {
        Node root = null;
        /* Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            8   4   5   6
               /   / \   \
             10   7   9   5
        */

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(8);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.left.right.left = new Node(10);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(9);
        root.right.right.right = new Node(5);

        findMaxSumPath(root);
    }
}
