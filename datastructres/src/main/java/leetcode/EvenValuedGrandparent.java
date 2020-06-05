package main.java.leetcode;

public class EvenValuedGrandparent {

    public int sumEvenGrandparent(TreeNode root) {

        return helper(root,null,null); //Perform DFS
    }

    private int helper(TreeNode current,TreeNode parent,TreeNode grandParent){
        int sum=0;
        if(current==null) return 0;
        if(grandParent!=null && grandParent.val % 2 == 0){
             sum+=current.val;
        }
        sum+= helper(current.left,current,parent);
        sum+=helper(current.right,current,parent);
        return sum;

    }

    public static void main(String[] args) {
        EvenValuedGrandparent evenValuedGrandparent=new EvenValuedGrandparent();
        TreeNode node= new TreeNode(6);
        node.left = new TreeNode(7);
        node.right = new TreeNode(8);
        node.left.left=new TreeNode(2);
        node.left.right=new TreeNode(7);
        node.right.right=new TreeNode(3);
        node.right.left=new TreeNode(1);
        node.left.left.left=new TreeNode(9);
        node.left.right.right=new TreeNode(4);
        node.left.right.left=new TreeNode(1);
        node.right.right.right=new TreeNode(5);
        System.out.println(evenValuedGrandparent.sumEvenGrandparent(node));
    }
}
