package main.java.topcodingquestion.treesandgraphs;

public class LowestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
    public Node lowestCommonAncestorIII(Node p, Node q) {
        if(p == null || q==null)return null;
        Node a=p;
        Node b=q;
        while(a!=b){
            a=a==null?q:a.parent;
            b=b==null?p:b.parent;
        }
        return a;
    }
}
