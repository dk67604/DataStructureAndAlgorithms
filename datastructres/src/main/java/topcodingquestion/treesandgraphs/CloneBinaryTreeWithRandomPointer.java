package main.java.topcodingquestion.treesandgraphs;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/clone-binary-tree-with-random-pointer/
public class CloneBinaryTreeWithRandomPointer {
    public NodeCopy copyRandomBinaryTree(Node root) {
        //Create a map to store mapping from a node to its clone
        Map<Node, NodeCopy> map = new HashMap<>();
        //clone data,left, and right pointers for each node of the original
        // binary tree, and put references into map
        cloneLeftRightPointers(root, map);
        //update random pointer from the original binary tree
        updateRandomPointer(root, map);
        //return the clone root node
        return map.get(root);

    }

    //Recursive function to copy random pointers from the original binary tree
    //into the clones binary tree using map
    private void updateRandomPointer(Node root, Map<Node, NodeCopy> map) {
        //base case
        if (map.get(root) == null) {
            return;
        }
        //update the random pointer of the cloned node
        map.get(root).random = map.get(root.random);
        //recur for the left and right tree
        updateRandomPointer(root.left, map);
        updateRandomPointer(root.right, map);
    }

    // Recursive function to clone the data, left, and right pointers for
    // each node of a binary tree into a given map
    private NodeCopy cloneLeftRightPointers(Node root, Map<Node, NodeCopy> map) {
        //base case
        if (root == null) {
            return null;
        }
        // clone all fields of the root node except the random pointer
        // create a new node with the same data as the root node
        map.put(root, new NodeCopy(root.val));
        //clone the left and right sub-tree
        map.get(root).left = cloneLeftRightPointers(root.left, map);
        map.get(root).right = cloneLeftRightPointers(root.right, map);
        //return cloned node
        return map.get(root);
    }
}
