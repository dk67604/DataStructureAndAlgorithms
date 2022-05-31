package main.java.leetcode.nary_tree;


import main.java.datastructure.NAryTree;

import java.util.*;

public class NAryTreeToDLL {
    static NAryTree tail;
    public static void push(NAryTree node){
        tail.next = node;
        node.prev = tail;
        tail = node;
    }
    public static NAryTree preorder(NAryTree root) {
        NAryTree head = root;
        tail = root;
        if(root==null)
            return null;
        Stack<NAryTree> stack=new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            NAryTree node =stack.pop();
            if(tail != node){
                push(node);
            }

            for(int i=node.children.size()-1;i>=0;i--){
                stack.add(node.children.get(i));
            }
        }
        return head;
    }
    public static void print(NAryTree head){
        while (head!=null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        NAryTree root = new NAryTree(1);
        List<NAryTree> children = new ArrayList<NAryTree>();
        children.add(new NAryTree(3));
        children.add(new NAryTree(2));
        children.add(new NAryTree(4));
        root.children = children;
        NAryTree child = root.children.get(0);
        children = new ArrayList<NAryTree>();
        children.add(new NAryTree(5));
        children.add(new NAryTree(6));
        child.children = children;
        NAryTree head = preorder(root);
        print(head);

    }
}
