package main.java.leetcode.nary_tree;

import java.util.concurrent.atomic.AtomicInteger;

public class NAryTreeDiameter {
    public int diameter(Node root) {
        AtomicInteger dm = new AtomicInteger();
        height(root,dm);
        return dm.get();
    }

    private int height(Node node,AtomicInteger dm){
        if(node.children.size() == 0){
            return 0;
        }
        int maxHeight1 =0, maxHeight2 =0;
        for(Node child: node.children){
            int parentHeight = height(child,dm) + 1;
            if(parentHeight > maxHeight1 ){
                maxHeight2 = maxHeight1;
                maxHeight1 = parentHeight;
            }else if(parentHeight > maxHeight2){
                maxHeight2 = parentHeight;
            }
            int distance = maxHeight1 + maxHeight2;
            dm.set(Math.max(dm.get(),distance));
        }
        return maxHeight1;
    }
}
