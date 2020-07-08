package main.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.
 *
 * Write a data structure CBTInserter that is initialized with a complete binary tree and supports the following operations:
 *
 * CBTInserter(TreeNode root) initializes the data structure on a given tree with head node root;
 * CBTInserter.insert(int v) will insert a TreeNode into the tree with value node.val = v so that the tree remains complete, and returns the value of the parent of the inserted TreeNode;
 * CBTInserter.get_root() will return the head node of the tree.
 */
public class CBTInserter {

    List<TreeNode> tree;

    public CBTInserter(TreeNode root) {
        tree=new ArrayList<>();
        tree.add(root);
        for(int i=0;i<tree.size();i++){
            if(tree.get(i).left!=null)tree.add(tree.get(i).left);
            if(tree.get(i).right!=null)tree.add(tree.get(i).right);
        }

    }

    public int insert(int v) {
        //Node tree[i] has left child tree[2 * i + 1] and tree[2 * i + 2]
        //we can find parent of any node at index N-1/2
        int N=tree.size();
        TreeNode node=new TreeNode(v);
        tree.add(node);
        if(N%2==1)
            tree.get((N-1)/2).left=node;
        else
            tree.get((N-1)/2).right=node;
        return tree.get((N-1)/2).val;
    }

    public TreeNode get_root() {
        //current root is stored at index 0
        return tree.get(0);
    }
}
