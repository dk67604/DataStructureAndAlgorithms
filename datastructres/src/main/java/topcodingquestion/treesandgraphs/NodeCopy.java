package main.java.topcodingquestion.treesandgraphs;

public class NodeCopy {
    public int val;
    public NodeCopy left;
    public NodeCopy right;
    public NodeCopy next;
    public NodeCopy random;

    public NodeCopy() {
    }

    public NodeCopy(int _val) {
        val = _val;
    }

    public NodeCopy(int _val, NodeCopy _left, NodeCopy _right, NodeCopy _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
