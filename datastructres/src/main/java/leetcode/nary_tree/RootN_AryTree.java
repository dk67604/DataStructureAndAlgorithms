package main.java.leetcode.nary_tree;


import java.util.List;

/*
Given all the nodes of an N-ary tree as an array  Node[] tree where each node has a unique value.

Find and return the root of the N-ary tree.



Follow up:

Could you solve this problem in constant space complexity with a linear time algorithm?



Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).



For example, the above tree is serialized as [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14].
 */
public class RootN_AryTree {
    public Node findRoot(List<Node> tree) {
        if(tree == null || tree.size() ==0){
            return null;
        }

        long sum=0;
        for (Node node:tree){
            if(node!=null)
                //Add current node value to sum
                sum^=node.val;
            // For each child - reduce value of child from sum
            for (Node child:node.children){
                sum^=child.val;
            }
        }
        for (Node node:tree){
            if(node.val == sum){
                return node;
            }
        }
        return null;

    }

}
