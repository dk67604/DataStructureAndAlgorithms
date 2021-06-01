package main.java.topcodingquestion.treesandgraphs;

//https://www.geeksforgeeks.org/inorder-succesor-node-binary-tree/
//We will do a reverse inorder traversal and keep the track of current visited node. Once we found the element, last tracked element would be our answer.
public class InorderSuccessorBinaryTree {
    TreeNode successor;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        InorderSuccessorBinaryTree inorderSuccessorBinaryTree = new InorderSuccessorBinaryTree();
        System.out.println(inorderSuccessorBinaryTree.inOrderSuccessor(root, 5).val);
        System.out.println(inorderSuccessorBinaryTree.inOrderSuccessor(root, 3).val);
        System.out.println(inorderSuccessorBinaryTree.inOrderSuccessor(root, 4).val);

    }

    public TreeNode inOrderSuccessor(TreeNode root, int key) {
        helper(root, new PTreeNode(), key);
        return successor;
    }

    private void helper(TreeNode node, PTreeNode pNode, int key) {
        if (node.right != null) {
            helper(node.right, pNode, key);
        }
        if (node.val == key)
            successor = pNode.pre;
        pNode.pre = node;
        if (node.left != null) {
            helper(node.left, pNode, key);
        }
    }

    class PTreeNode {
        TreeNode pre;

        PTreeNode() {
            pre = null;
        }
    }
}
