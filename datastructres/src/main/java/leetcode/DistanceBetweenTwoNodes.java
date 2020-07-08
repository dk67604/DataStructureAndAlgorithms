package main.java.leetcode;

public class DistanceBetweenTwoNodes {
    private boolean isNodePresent(TreeNode node,TreeNode root){
        if(root == null) return false;
        if(root == node){
            return true;
        }
        return isNodePresent(node,root.left) || isNodePresent(node,root.right);
    }

    private int findLevel(TreeNode root, TreeNode node, int level){
        if(root == null) return Integer.MIN_VALUE;
        if(root == node) return level;
        int left = findLevel(root.left,node,level+1);
        if(left!=Integer.MIN_VALUE){
            return left;
        }
        return findLevel(root.right,node,level+1);
    }

    private TreeNode findLCA(TreeNode root, TreeNode x,TreeNode y){
        if(root == null) return  null;
        if(root == x || root == y) return root;
        TreeNode left = findLCA(root.left,x,y);
        TreeNode right = findLCA(root.right,x,y);
        // if x is found in one subtree and y is found in other subtree,
        // update lca to current node
        if(left!=null && right!=null )
            return root;
        //if x and y exists in right return right tree otherwise return left tree
        return left != null?left:right;
    }

    public int findDistance(TreeNode root,TreeNode x, TreeNode y){
        TreeNode lca = null;
        if(isNodePresent(x,root) && isNodePresent(y,root)){
            lca = findLCA(root,x,y);
        }else {
            return Integer.MIN_VALUE;
        }
        return findLevel(lca,x,0) + findLevel(lca,y,0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        DistanceBetweenTwoNodes distanceBetweenTwoNodes = new DistanceBetweenTwoNodes();
        //Distance 7 and 6
        System.out.println(distanceBetweenTwoNodes.findDistance(root, root.right.left.left, root.right.right));
    }
}
