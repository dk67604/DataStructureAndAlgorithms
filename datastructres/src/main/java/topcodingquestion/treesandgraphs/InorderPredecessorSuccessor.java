package main.java.topcodingquestion.treesandgraphs;

public class InorderPredecessorSuccessor {
    TreeNode lastTrackNode, succ, pred;
    boolean isPred;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(20);
        root.right = new TreeNode(60);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(55);
        root.right.right = new TreeNode(70);
        InorderPredecessorSuccessor inorderPredecessorSuccessor = new InorderPredecessorSuccessor();
        inorderPredecessorSuccessor.inorderPredecessorSuccessor(root, 55);
        inorderPredecessorSuccessor.inorderPredecessorSuccessor(root, 70);

    }

    public void inorderPredecessorSuccessor(TreeNode root, int key) {
        lastTrackNode = null;
        succ = null;
        pred = null;
        isPred = false;
        helper(root, key);
        System.out.println("Successor:" + (succ != null ? succ.val : "None"));
        System.out.println("Predecessor:" + (pred != null ? pred.val : "None"));

    }

    private void helper(TreeNode node, int key) {
        if (node == null)
            return;
        helper(node.right, key);
        if (isPred) {
            pred = node;
            isPred = false;
        }
        if (node.val == key) {
            succ = lastTrackNode;
            isPred = true;
        }
        lastTrackNode = node;
        helper(node.left, key);

    }
}
