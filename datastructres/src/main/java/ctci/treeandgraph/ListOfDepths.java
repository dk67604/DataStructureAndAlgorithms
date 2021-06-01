package main.java.ctci.treeandgraph;

import main.java.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths {

    public ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        createLevelLinkedList(root, result, 0);
        return result;
    }

    public void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) return; //base
        LinkedList<TreeNode> list = null;
        if (lists.size() == level) {
            list = new LinkedList<TreeNode>();
            /* Levels are always traversed in order. So, if this is the first
             * time we've visited level i, we must have seen level 0 through i -1.
             * We can therefore safely add the level at the end.
             */
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);

    }
}
