package main.java.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeDeserializeTree {
	 // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       return helper(root,"");
        
    }
    public String helper(TreeNode root,String res) {
    	 if(root==null) {
    		 res+="#,";
         	return res;
         }
    	 else {
    		 res+=String.valueOf(root.val)+",";
    		 res=helper(root.left,res);
    		 res=helper(root.right,res);
    	 }
    	 return res;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	String[] temp=data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(temp));

        return helper(data_list);
    }
    
    public TreeNode helper(List<String> l) {
    	  if (l.get(0).equals("#")) {
    	      l.remove(0);
    	      return null;
    	    }

    	    TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
    	    l.remove(0);
    	    root.left = helper(l);
    	    root.right = helper(l);

    	    return root;
    }
    
    public static void main(String[] args) {
		SerializeDeserializeTree serializeDeserializeTree=new SerializeDeserializeTree();
		TreeNode root=serializeDeserializeTree.deserialize("-1,0,#,#,1,#,#,");
	}
}
