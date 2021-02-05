package main.java.techiedelight.binarytree;

public class Node {
    int data;
    char val;
    Node left;
    Node right;
    Node random;

    Node(int data) {
        this.data = data;
    }

    Node(char val) {
        this.val = val;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }


}