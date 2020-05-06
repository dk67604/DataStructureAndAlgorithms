package main.java.leetcode;

import java.util.*;

public class PathSum {
	public List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>> list=new ArrayList<>();
		helper(list,new ArrayList<Integer>(),root,sum);
		return list;
	}
	public void helper(List<List<Integer>> list,List<Integer> currentList,TreeNode root, int sum) {
		if(root==null)
			return;
		currentList.add(new Integer(root.val));
		if(root.left==null && root.right==null && sum-root.val==0) {
			list.add(new LinkedList<>(currentList));
			currentList.remove(currentList.size()-1);
			return;
		}else {
			helper(list,currentList,root.left,sum-root.val);
			helper(list,currentList,root.right,sum-root.val);
		}
		currentList.remove(currentList.size()-1);
	}
}
