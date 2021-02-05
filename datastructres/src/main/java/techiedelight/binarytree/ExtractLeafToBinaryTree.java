package main.java.techiedelight.binarytree;


class NodeWrapper {
    Node node;
}

// Use inorder traversal to extract leaf node
public class ExtractLeafToBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);

        root.right.left.left = new Node(10);
        root.right.left.right = new Node(11);

        // to keep track of the head of the doubly linked list
        NodeWrapper head = new NodeWrapper();

        // to keep track of the tail of the doubly linked list
        NodeWrapper tail = new NodeWrapper();
        ExtractLeafToBinaryTree extractLeafToBinaryTree = new ExtractLeafToBinaryTree();
        root = extractLeafToBinaryTree.construct(root, head, tail);

        System.out.print("Extracted doubly linked list is ");
        extractLeafToBinaryTree.printDDL(head.node);

        System.out.print("\nPreorder traversal of the final tree is ");
        extractLeafToBinaryTree.preorder(root);
    }

    // Traverse a given binary tree using the preorder traversal
    public void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Print the given doubly linked list from left to right
    public void printDDL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.right;
        }
    }

    // Function to extract leaves of a binary tree into a doubly linked list
    public Node construct(Node root, NodeWrapper head, NodeWrapper tail) {
        //base case
        if (root == null) {
            return null;
        }
        //recur for the left subtree
        root.left = construct(root.left, head, tail);
        //if the current node is a leaf
        if (root.isLeaf()) {
            // This is true only for the leftmost leaf node
            if (head.node == null) {
                // point the head of the doubly linked list to the
                // current leaf node and initialize the tail pointer
                head.node = tail.node = root;
            } else {
                // set left pointer of the current node to the tail
                // of the doubly linked list
                root.left = tail.node;
                // set the right pointer of the tail to the current node
                tail.node.right = root;
                //update the tail
                tail.node = root;
            }
            // return null to remove the current node from the binary tree;
            return null;
        }
        // recur for the right subtree
        root.right = construct(root.right, head, tail);
        // return root node
        return root;
    }

}
