package main.java.topcodingquestion.treesandgraphs.nary;

public class NAryMaxDepth {
    public int maxDepth(Node root) {
        if (root == null){
            return 0;
        }
        int height=0;
        for (Node n:root.children){
            height=Math.max(height,maxDepth(n));

        }
        return 1 + height;
    }
}
