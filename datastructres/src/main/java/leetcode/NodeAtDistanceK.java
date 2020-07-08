package main.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class NodeAtDistanceK {
	 Map<TreeNode, TreeNode> map;
	 public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
	        map=new HashMap<>();
	        
	        Queue<TreeNode> queue=new LinkedList<>();
	        dfs(root,null);
	        queue.add(null);
	        queue.add(target);
	        Set<TreeNode> seen=new HashSet<TreeNode>();
	        seen.add(target);
	        seen.add(null);
	        int dist=0;
	        while(!queue.isEmpty()) {
	        	TreeNode node=queue.poll();
	        	if(node==null) {
	        		if(dist==K) {
	        			List<Integer> list=new ArrayList<>();
	        			for(TreeNode n:queue) {
	        				list.add(n.val);
	        			}
	        			return list;
	        		}
	        		queue.offer(null);
	        		dist++;
	        	}
	        	else {
	        		if(!seen.contains(node.left)) {
	        			seen.add(node.left);
	        			queue.offer(node.left);
	        		}
	        		if(!seen.contains(node.right)) {
	        			seen.add(node.right);
	        			queue.offer(node.right);
	        		}
	        		TreeNode par=map.get(node);
	        		if(!seen.contains(par)) {
	        			seen.add(par);
	        			queue.offer(par);
	        		}
	        	}
	        }
	        return new ArrayList<>();
	    }
	 
	 public void dfs(TreeNode node, TreeNode parent) {
		 if(node!=null) {
		 map.put(node, parent);
		 dfs(node.left,node);
		 dfs(node.right,node);
	 }
	 }


}
