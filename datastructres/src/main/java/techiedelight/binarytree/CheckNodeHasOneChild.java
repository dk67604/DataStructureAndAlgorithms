package main.java.techiedelight.binarytree;

// This also is check if binary is skewed or not
// This can be checked using height of tree = size of tree
public class CheckNodeHasOneChild {


    public static void main(String[] args) {
        Node root = new Node(15);
        root.right = new Node(30);
        root.right.left = new Node(25);
        root.right.left.left = new Node(18);
        root.right.left.left.right = new Node(20);
        CheckNodeHasOneChild checkNodeHasOneChild = new CheckNodeHasOneChild();
        boolean isSkewed = checkNodeHasOneChild.isSkewedTree(root);
        if (isSkewed) {
            System.out.println("The binary tree is skewed");
        } else {
            System.out.println("The binary tree is not skewed");
        }
    }

    private int getSize(Node node) {
        if (node == null)
            return 0;

        return 1 + getSize(node.left) + getSize(node.right);
    }

    private int getHeight(Node node) {
        // Base case: an empty tree has a height of 0
        if (node == null)
            return 0;
        return 1 + Integer.max(getHeight(node.left), getHeight(node.right));
    }

    public boolean isSkewedTree(Node root) {
        return getSize(root) == getHeight(root);
    }
}
