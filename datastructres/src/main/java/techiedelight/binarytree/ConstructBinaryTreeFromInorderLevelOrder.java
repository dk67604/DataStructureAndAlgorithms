package main.java.techiedelight.binarytree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderLevelOrder {
    // Recursive function to perform inorder traversal on a given binary tree
    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        int[] level = {1, 2, 3, 4, 5, 6, 7};
        ConstructBinaryTreeFromInorderLevelOrder constructBinaryTreeFromInorderLevelOrder =
                new ConstructBinaryTreeFromInorderLevelOrder();
        Node root = constructBinaryTreeFromInorderLevelOrder.buildTree(inorder, level);

        System.out.print("Inorder traversal of the constructed tree is ");
        inorderTraversal(root);
    }

    public Node buildTree(int[] inOrder, int[] levelOrder) {
        // create a map to efficiently find the index of an element in a
        // level order sequence
        Map<Integer, Integer> levelIndex = new HashMap<>();
        for (int i = 0; i < levelOrder.length; i++) {
            levelIndex.put(levelOrder[i], i);
        }
        Node root = helper(inOrder, levelIndex, 0, inOrder.length - 1);
        return root;
    }

    // Recursive function to construct a binary tree from a given inorder and
    // level order traversals
    private Node helper(int[] inOrder, Map<Integer, Integer> map, int start, int end) {
        // base case
        if (start > end) {
            return null;
        }
        // find the root node index in sequence `inorder[]` to determine the
        // left and right subtree boundary
        int index = start;
        for (int j = start + 1; j <= end; j++) {
            // Find node with minimum index in level order traversal.
            // That would be the root node of the sequence `inorder[start, end]`
            if (map.get(inOrder[j]) < map.get(inOrder[index])) {
                index = j;
            }
        }
        // construct the root node
        Node root = new Node(inOrder[index]);
        // recursively construct the left subtree
        root.left = helper(inOrder, map, start, index - 1);
        // recursively construct the right subtree
        root.right = helper(inOrder, map, index + 1, end);
        return root;
    }

}
