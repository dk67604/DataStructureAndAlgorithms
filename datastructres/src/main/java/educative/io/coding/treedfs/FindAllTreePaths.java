package main.java.educative.io.coding.treedfs;

import java.util.ArrayList;
import java.util.List;

public class FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPathsRecursive(root,allPaths,sum,currentPath);
        return allPaths;
    }

    private static void findPathsRecursive(TreeNode currentNode,List<List<Integer>> allPaths,int sum,
                                           List<Integer> currentPath){

        if(currentNode == null)
            return;

        // add the current node to the path
        currentPath.add(currentNode.val);
        // if the current node is a leaf and its value is equal to sum, save the current path
        if(currentNode.val == sum && currentNode.left == null && currentNode.right == null){
            allPaths.add(new ArrayList<>(currentPath));
        }else {
            // traverse the left-sub tree
            findPathsRecursive(currentNode.left,allPaths,sum - currentNode.val,currentPath);
            // traverse the right-sub tree
            findPathsRecursive(currentNode.right,allPaths,sum - currentNode.val,currentPath);
        }

        // remove the current node from the path to backtrack,
        // we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() -1);

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
