package main.java.educative.io.coding.treedfs;

public class TreeDiameter {

    public static int findDiameter(TreeNode root) {
        int[] ans = {1};
        calculateHeight(root,ans);
        return ans[0];
    }
    private static int calculateHeight(TreeNode currentNode,int[] ans){
        if(currentNode == null)
            return 0;
        int leftTreeHeight = calculateHeight(currentNode.left,ans);
        int rightTreeHeight = calculateHeight(currentNode.right,ans);

        // diameter at the current node will be equal to the height of left subtree +
        // the height of right sub-trees + '1' for the current node
        int diameter = leftTreeHeight + rightTreeHeight + 1;
        // update the global tree diameter
        ans[0] = Math.max(ans[0],diameter);

        // height of the current node will be equal to the maximum of the heights of
        // left or right subtrees plus '1' for the current node
        return Math.max(leftTreeHeight,rightTreeHeight) + 1;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
    }
}
