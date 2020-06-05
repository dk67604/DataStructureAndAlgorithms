package main.java.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathInZigZagLabelledBinaryTree {

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new ArrayList<>();
        int node_count =1;
        int level =1;
        //Determine the level of label
        while (label>=node_count*2){
            node_count*=2; //At each level number of node increases in power of 2
            level++;
        }
        //Iterate from the target label to the root
        while (label!=0){
            list.add(label);
            //Calculation of new position happened due to incursion
            int levelmax = (int)Math.pow(2,level) -1;
            int levelmin = (int)Math.pow(2,level-1);
            label =(int)((levelmax+levelmin-label)/2);//Subtract label to get offset and divide by to get parent
            level--;
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        PathInZigZagLabelledBinaryTree pathInZigZagLabelledBinaryTree = new PathInZigZagLabelledBinaryTree();
        System.out.println(pathInZigZagLabelledBinaryTree.pathInZigZagTree(14));
    }
}
