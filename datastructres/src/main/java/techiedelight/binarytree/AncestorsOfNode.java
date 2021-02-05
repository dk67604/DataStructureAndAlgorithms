package main.java.techiedelight.binarytree;

public class AncestorsOfNode {

    public static boolean printAncestors(Node root, int node) {
        //base case
        if (root == null)
            return false;
        //return true if a given node is found
        if (root.data == node)
            return true;
        //search node in left subtree
        boolean left = printAncestors(root.left, node);

        // search node in the right subtree
        boolean right = false;
        if (!left) {
            right = printAncestors(root.right, node);
        }
        // if the given node is found in either left or right subtree,
        // the current node is an ancestor of a given node
        if (left || right) {
            System.out.print(root.data + " ");
        }
        // return true if a node is found
        return left || right;
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

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.right.right = new Node(8);

        int node = 7;
        printAncestors(root, node);
    }
}
