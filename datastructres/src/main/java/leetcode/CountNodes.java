package main.java.leetcode;

public class CountNodes {
    public int countNodes(TreeNode root) {
        int countNode=0,h=height(root);
        while(root!=null){
            if(height(root.right)==(h-1)){
                countNode+=1<<h;
                root=root.right;
            }else{
                countNode+=1<<h-1;
                root=root.left;
            }
            h--;
        }
        return countNode;
        }
    
    public int height(TreeNode node){
        if(node==null) return -1;
        else{
            return 1+height(node.left);
        }
    }
    public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		root.right=new TreeNode(3);
		root.right.left=new TreeNode(6);
		CountNodes countNodes=new CountNodes();
		countNodes.countNodes(root);
	}
}
