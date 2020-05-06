package main.java.leetcode;

public class AnnonatedNode {
    TreeNode node;
    int depth,pos;
    public AnnonatedNode(TreeNode n,int depth,int pos){
        this.node=n;
        this.depth=depth;
        this.pos=pos;
    }
}
