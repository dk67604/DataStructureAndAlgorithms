package main.java.topcodingquestion.treesandgraphs.nary;

import java.util.*;

public class NAryLevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> currentLevel =new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                Node node=queue.poll();
                currentLevel.add(node.val);
                for(Node n:node.children){
                    queue.offer(n);
                }

            }
            result.add(currentLevel);

        }
        return result;

    }
}
