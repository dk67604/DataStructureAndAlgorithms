package main.java.topcodingquestion.treesandgraphs.nary;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NAryPostOrder {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> result=new LinkedList<>();
        if(root==null)return result;
        Stack<Node> stack=new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node node=stack.pop();
            result.addFirst(node.val);
            for(Node n:node.children){
                stack.add(n);
            }
        }
        return result;
    }
}
