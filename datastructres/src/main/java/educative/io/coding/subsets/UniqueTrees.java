package main.java.educative.io.coding.subsets;

import main.java.educative.io.coding.treedfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueTrees {

    public static List<TreeNode> findUniqueTrees(int n) {
        if(n <= 0)
            return new ArrayList<TreeNode>();
        return findUniqueTreeRecursive(1,n);
    }

    private static List<TreeNode> findUniqueTreeRecursive(int start, int end){
        List<TreeNode> result = new ArrayList<>();
        // base condition, return 'null' for an empty sub-tree
        // consider n=1, in this case we will have start=end=1, this means we should have only one tree
        // we will have two recursive calls, findUniqueTreesRecursive(1, 0) & (2, 1)
        // both of these should return 'null' for the left and the right child
        if(start > end){
            result.add(null);
            return result;
        }
        for(int i = start; i<=end; i++){
            List<TreeNode> leftSubtree = findUniqueTreeRecursive(start,i-1);
            List<TreeNode> rightSubTree = findUniqueTreeRecursive(i+1,end);
            for(TreeNode leftNode : leftSubtree){
                for(TreeNode rightNode : rightSubTree){
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<TreeNode> result = UniqueTrees.findUniqueTrees(2);
        System.out.print("Total trees: " + result.size());
    }
}
