package main.java.leetcode;

public class PathSumIII {
	
	 public int pathSum(TreeNode root, int sum) {
		 // Run DFS for a root, left and right node respectively
		    if(root==null) return 0;
	        return helper(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
	        
	    }
	    
	    public int helper(TreeNode root,int sum){
	    	int result=0;
	        if(root==null)
	            return result;
	        if(sum-root.val==0)
	            result++;        
	         result+=helper(root.left,sum-root.val);
	         result+=helper(root.right,sum-root.val);
	        return result;
	        
	          
	        }
	    public static void main(String[] args) {
			TreeNode root=new TreeNode(10);
			root.left=new TreeNode(5);
			root.left.left=new TreeNode(3);
			root.right=new TreeNode(-3);
			PathSumIII pathSumIII=new PathSumIII();
			System.out.println(pathSumIII.pathSum(root, 8));
		}
	    
}
