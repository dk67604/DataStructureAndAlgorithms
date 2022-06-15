package main.java.topcodingquestion.treesandgraphs.nary;


import java.util.Arrays;
import java.util.Collections;

public class NAryLCA {
    public Node findLCA(Node root, Node src, Node dst) {
        if (root == null || root == src || root == dst) return root;
        if (root.children == null || root.children.size() == 0) return null;
        int count = 0;
        Node res = null;
        for (Node child : root.children) {
            Node cur = findLCA(child, src, dst);
            if (cur != null) {
                count++;
                res = cur;
            }
        }
        if (count == 2) return root;
        return res;
    }

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        Node r1 = new Node(5);
        Node r2 = new Node(1);
        Node r3 = new Node(2);
        r1.children = Arrays.asList(r2, r3);

        Node r4 = new Node(6);
        Node r5 = new Node(8);
        Node r6 = new Node(18);
        r3.children = Arrays.asList(r4, r5, r6);

        Node r7 = new Node(10);
        r4.children = Collections.singletonList(r7);
        NAryLCA nAryLCA = new NAryLCA();
        Node res = nAryLCA.findLCA(r1, r7, r6);
        System.out.println(res.val);
    }
}
