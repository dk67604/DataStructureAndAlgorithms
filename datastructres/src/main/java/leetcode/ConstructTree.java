package main.java.leetcode;
import java.util.*;
public class ConstructTree {
	 public TreeNode constructFromPrePost(int[] pre, int[] post) {
	        Deque<TreeNode> s = new ArrayDeque<>();
	        s.offer(new TreeNode(pre[0]));
	        for (int i = 1, j = 0; i < pre.length; ++i) {
	            TreeNode node = new TreeNode(pre[i]);
	            while (s.getLast().val == post[j]) {
	                s.pollLast(); j++;
	            }
	            if (s.getLast().left == null) s.getLast().left = node;
	            else s.getLast().right = node;
	            s.offer(node);
	        }
	        return s.getFirst();
	    }
	 
	 public static void main(String[] args) {
		int [] pre=new int[] {1,2,4,5,3,6,7};
		int[] post=new int[] {4,5,2,6,7,3,1};
	  ConstructTree constructTree=new ConstructTree();
	  constructTree.constructFromPrePost(pre, post);
	 
	 }
}
