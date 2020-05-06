package main.java.leetcode;
import java.util.*;
public class BuildTree {
//	public TreeNode str2tree(String s) {
//        Stack<TreeNode> stack = new Stack<>();
//        for(int i = 0, j = i; i < s.length(); i++, j = i){
//            char c = s.charAt(i);
//            if(c == ')')    stack.pop();
//            else if(c >= '0' && c <= '9' || c == '-'){
//                while(i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
//                TreeNode currentNode = new TreeNode(Integer.valueOf(s.substring(j, i + 1)));
//                if(!stack.isEmpty()){
//                    TreeNode parent = stack.peek();
//                    if(parent.left != null)    parent.right = currentNode;
//                    else parent.left = currentNode;
//                }
//                stack.push(currentNode);
//            }
//        }
//        return stack.isEmpty() ? null : stack.peek();
//    }
	public TreeNode str2tree(String s) {
        Stack<TreeNode> stack=new Stack<>();
        for(int i=0,j=i;i<s.length();i++,j=i){
            if(s.charAt(i)==')') stack.pop();
            else if(s.charAt(i)>='0' && s.charAt(i)<='9'|| s.charAt(i)=='-'){
                while(i+1<s.length() && (s.charAt(i+1)>='0' && s.charAt(i+1)<='9')) i++;
                TreeNode current=new TreeNode(Integer.valueOf(s.substring(j,i+1)));
                if(!stack.isEmpty()){
                    TreeNode parent=stack.peek();
                    if(parent.left!=null)parent.right=current;
                    else
                    parent.left=current;
                }
                stack.push(current);
            }
          
        }
        return stack.isEmpty()?null:stack.peek();
    }
	public static void main(String[] args) {
		BuildTree buildTree=new BuildTree();
		buildTree.str2tree("-4(2(3)(1))(6(5)(7))");
	}
}
