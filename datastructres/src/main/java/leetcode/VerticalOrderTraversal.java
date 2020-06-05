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


	//Second version we need to sort the element which are at same position
	public List<List<Integer>> verticalOrderSort(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		//Store the element row-column wise ,key is col and row is all element in column
		Map<Integer,List<Integer>> map = new HashMap<>();
		Queue<Integer> columnIndex = new LinkedList<>();
		columnIndex.add(0);
		queue.add(root);
		int minCol = 0,maxCol =0;
		while (!queue.isEmpty()){
			int size = queue.size();
			Map<Integer,List<Integer>> temp = new HashMap<>();
			for (int i =0;i<size;i++){
				TreeNode node = queue.poll();
				int col = columnIndex.poll();
				if(!temp.containsKey(col)) temp.put(col,new ArrayList<>());
				map.get(col).add(node.val);
				if(node.left!=null){
					queue.add(node.left);
					columnIndex.add(col-1);
					minCol = Math.min(minCol,col-1);
				}
				if(node.right!=null){
					queue.add(node.right);
					columnIndex.add(col+1);
					maxCol = Math.max(maxCol,col+1);
				}
			}
			for (int key:temp.keySet()){
				if(!map.containsKey(key)) map.put(key,new ArrayList<>());
				List<Integer> list = temp.get(key);
				Collections.sort(list);
				map.get(key).addAll(list);
			}
		}
		for (int i =  minCol;i<=maxCol;i++ ){
			res.add(map.get(i));
		}
        return res;

	}
}
