package main.java.leetcode;

public class DeleteNodeBST {
/*
Recursively find the node that has the same value as the key,
while setting the left/right nodes equal to the returned subtree
Once the node is found, have to handle the below 4 cases
1.node doesn't have left or right - return null
2.node only has left subtree- return the left subtree
3.node only has right subtree- return the right subtree
4.node has both left and right - find the minimum value in the right subtree,
set that value to the currently found node,
then recursively delete the minimum value in the right subtree
 */
    public TreeNode deleteNode(TreeNode root, int key) {

        //Base case
        if (root == null){
            return null;
        }

        if(key < root.val){
            root.left = deleteNode(root.left,key);
        }
       else if(key>root.val){
            root.right = deleteNode(root.right,key);
        }else {
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else {
                TreeNode minNode = findMin(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right,root.val);
            }
        }
        return root;
    }

    public TreeNode findMin(TreeNode node){
        while (node.left!=null){
            node = node.left;
        }
        return node;
    }
}
