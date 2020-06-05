package main.java.leetcode;
import java.util.*;
public class BSTToDLL {
	NodeDL prev=null;
    public NodeDL treeToDoublyList(NodeDL root) {
        if(root==null) return null;
        NodeDL dummy=new NodeDL(0,null,null);
        prev=dummy;
        helper(root);
        prev.right=dummy.right;
        dummy.right.left=prev;
        return dummy.right;
    }
    public void helper(NodeDL root){
        Stack<NodeDL> stack=new Stack<>();
        
        
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            prev.right=root;
            root.left=prev;
            prev=root;
            root=root.right;
        }
    }

    public NodeDL bstToDLL(NodeDL root){
        if(root == null) return null;
        NodeDL head = null;
        NodeDL prev = null;
        Stack<NodeDL> stack=new Stack<>();
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(head == null){
                head =root;
            }if(prev!=null){
                prev.right = root;
                root.left = prev;
            }
            prev =root;
            root = root.right;
        }
        return head;
    }
    
    public static void main(String[] args) {
		NodeDL root=new NodeDL(2,null,null);
		root.left=new NodeDL(1,null,null);
		root.right=new NodeDL(3,null,null);
		BSTToDLL bstToDLL=new BSTToDLL();
		//bstToDLL.treeToDoublyList(root);
		bstToDLL.bstToDLL(root);
	}
}
