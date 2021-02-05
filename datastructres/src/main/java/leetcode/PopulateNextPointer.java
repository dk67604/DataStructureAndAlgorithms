package main.java.leetcode;

public class PopulateNextPointer {
	 public void connect(TreeLinkNode root) {
		  
	        while(root != null){
	            TreeLinkNode tempChild = new TreeLinkNode(0);
	            TreeLinkNode currentChild = tempChild;
	            while(root!=null){
	                if(root.left != null) {
					currentChild.next = root.left;
	                currentChild = currentChild.next;
	                }
	                if(root.right != null) {
	                	currentChild.next = root.right;
	                	currentChild = currentChild.next;}
	                root = root.next;
	            }
	            root = tempChild.next;
	        }
	    
	 }
	 
	 public static void main(String[] args) {
		 TreeLinkNode root = new TreeLinkNode(1);
		 root.left = new TreeLinkNode(2);
		 root.right = new TreeLinkNode(3);
		 root.left.left = new TreeLinkNode(4);
		 root.left.right = new TreeLinkNode(5);
		 root.right.right = new TreeLinkNode(6);
		 root.right.right.left = new TreeLinkNode(7);
		 root.right.right.right = new TreeLinkNode(8);
		 PopulateNextPointer populateNextPointer = new PopulateNextPointer();
		 populateNextPointer.connect(root);
	 }
}
