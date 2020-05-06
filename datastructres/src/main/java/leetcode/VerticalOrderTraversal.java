package main.java.leetcode;

import java.util.*;
public class VerticalOrderTraversal {

	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> result=new ArrayList<>();
		if(root==null) {
			return result;
		}
		Queue<TreeNode> queue=new LinkedList<>(); // BFS level-order traversal
		Map<Integer,ArrayList<Integer>> map=new HashMap<>();
		Queue<Integer> columnList=new LinkedList<>(); // Queue for maintaining column index
		queue.add(root);
		columnList.add(0);
		int minCol=0,maxCol=0;// Calculate the width of tree, 
		//we need most min and most max
		while(!queue.isEmpty()) {
			TreeNode node=queue.poll();
			int col=columnList.poll();
			if(!map.containsKey(col)) {
				map.put(col, new ArrayList<>());
			}
			map.get(col).add(node.val);
			if(node.left!=null) {
				queue.add(node.left);
				columnList.add(col-1);
				minCol=Math.min(minCol, col-1);
			}
			if(node.right!=null) {
				queue.add(node.right);
				columnList.add(col+1);
				maxCol=Math.max(maxCol, col+1);
			}
		}
		
		for(int i=minCol;i<=maxCol;i++) {
			result.add(map.get(i));
		}
		return result;
	}
}
