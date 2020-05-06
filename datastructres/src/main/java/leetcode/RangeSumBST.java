package main.java.leetcode;

public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int L, int R) {

        int ans=0;
        ans=dfs(root,L,R,ans);
        return ans;

    }

    public int dfs(TreeNode node,int L,int R,int ans){
        if(node!=null){
            ans=dfs(node.left,L,R,ans)+dfs(node.right,L,R,ans);
            if(L<=node.val&& node.val<=R){
                ans+=node.val;
                return ans;
            }
        }else{
            return 0;
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(5);
        root.right=new TreeNode(15);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(7);
        root.right.right=new TreeNode(18);
        RangeSumBST rangeSumBST=new RangeSumBST();
        System.out.println(rangeSumBST.rangeSumBST(root,7,15));

    }
}
