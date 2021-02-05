package main.java.techiedelight.binarytree;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ConstructBinaryTreeFromInorderAndPostOrder {
    // Recursive function to perform inorder traversal on a given binary tree
    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    // Recursive function to perform postorder traversal on a given binary tree
    public static void postorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        /* Construct the following tree
                   1
                 /   \
                /     \
               2       3
              /       / \
             /       /   \
            4       5     6
                   / \
                  /   \
                 7     8
        */

        int[] inorder = {4, 2, 1, 7, 5, 8, 3, 6};
        int[] postorder = {4, 2, 7, 8, 5, 6, 3, 1};
        ConstructBinaryTreeFromInorderAndPostOrder constructBinaryTreeFromInorderAndPostOrder =
                new ConstructBinaryTreeFromInorderAndPostOrder();
        Node root = constructBinaryTreeFromInorderAndPostOrder.construct(inorder, postorder);

        // traverse the constructed tree
        System.out.print("Inorder traversal is ");
        inorderTraversal(root);
        System.out.print("\nPostorder traversal is ");
        postorderTraversal(root);
    }

    // Construct a binary tree from inorder and postorder traversals.
    // This function assumes that the input is valid, i.e., given
    // inorder and postorder sequences forming a binary tree.
    public Node construct(int[] inorder, int[] postorder) {
        int n = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        // `pIndex` stores the index of the next unprocessed node from the end
        // of the postorder sequence
        AtomicInteger pIndex = new AtomicInteger(n - 1);
        return construct(0, n - 1, postorder, pIndex, map);


    }

    private Node construct(int start, int end, int[] postorder, AtomicInteger pIndex,
                           Map<Integer, Integer> map) {
        //base case
        if (start > end) {
            return null;
        }
        // Consider the next item from the end of a given postorder sequence.
        // This value would be the root node of a subtree formed by sequence
        // `inorder[start, end]`.

        Node root = new Node(postorder[pIndex.getAndDecrement()]);

        // search the current node index in inorder sequence to determine
        // the boundary of the left and right subtree of the current node
        int index = map.get(root.data);
        // recursively construct the right subtree
        root.right = construct(index + 1, end, postorder, pIndex, map);
        // recursively construct the left subtree
        root.left = construct(start, index - 1, postorder, pIndex, map);
        //return the root node
        return root;
    }
}
