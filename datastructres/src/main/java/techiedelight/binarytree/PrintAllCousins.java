package main.java.techiedelight.binarytree;

import main.java.leetcode.TreeNode;

public class PrintAllCousins {

    // Function to find the level of the given node `x`
    public static int findLevel(Node root, Node x, int index, int level)
    {
        // return if the tree is empty or level is already found
        if (root == null || level != 0) {
            return level;
        }
 
        // if the given node is found, update its level
        if (root == x) {
            level = index;
        }
 
        // recur for the left and right subtree
        level = findLevel(root.left, x, index + 1, level);
        level = findLevel(root.right, x, index + 1, level);
 
        return level;
    }
    public static void printLevel(Node root, Node node, int level)
    {
        // base case
        if (root == null) {
            return;
        }
 
        // print cousins
        if (level == 1)
        {
            System.out.print(root.val + " ");
            return;
        }
 
        // recur for the left and right subtree if the given node
        // is not a child of the root
        if (!(root.left != null && root.left == node ||
                root.right != null && root.right == node))
        {
            printLevel(root.left, node, level - 1);
            printLevel(root.right, node, level - 1);
        }
    }
 
    // Function to print all cousins of a given node
    public static void printAllCousins(Node root, Node node)
    {
        // base case
        if (root == null || root == node) {
            return;
        }
 
        // find the level of the given node
        int level = findLevel(root, node, 1, 0);
 
        // print all cousins of a given node using its level number
        printLevel(root, node, level);
    }
 
    public static void main(String[] args)
    {
        /* Construct the following tree
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        printAllCousins(root, root.right.left);
    }

}
