package main.java.topcodingquestion.treesandgraphs.nary;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NAryPreorder {
    public List<Integer> preorder(Node root) {

        List<Integer> list=new LinkedList<>();
        if(root==null)
            return list;
        Stack<Node> stack=new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node node =stack.pop();
            list.add(node.val);
            for(int i=node.children.size()-1;i>=0;i--){
                stack.add(node.children.get(i));
            }
        }
        return list;
    }
}
