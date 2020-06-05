package main.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateSubtree {

    //use postorder traversal and store the tree in serialized format
    // Store the serial of the key in map
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        postOrder(root,new HashMap<String,Integer>(),res);
        return res;
    }

    public String postOrder(TreeNode node, Map<String,Integer> map, List<TreeNode> res){
        if(node == null) return "#";
        String serial = node.val + "," + postOrder(node.left,map,res) + postOrder(node.right,map,res);
        if(map.getOrDefault(serial,0) == 1) res.add(node);
        map.put(serial,map.getOrDefault(serial,0)+1);
        return serial;
    }
}
