package main.java.topcodingquestion.systemdesign;


import java.util.*;

public class SerializeDeserializeNAryTree {
    public String serialize(Node root) {
        List<String> list = new LinkedList<>();
        serializeHelper(root, list);
        return String.join(",", list);
    }

    private void serializeHelper(Node root, List<String> list) {
        if (root == null) return;
        else {
            list.add(String.valueOf(root.val));
            list.add(String.valueOf(root.children.size()));
            for (Node children : root.children) {
                serializeHelper(children, list);
            }
        }
    }

    public Node deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] nodes = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
        return deserializeHelper(queue);
    }

    private Node deserializeHelper(Queue<String> queue) {
        Node root = new Node();
        root.val = Integer.valueOf(queue.poll());
        int size = Integer.valueOf(queue.poll());
        root.children = new ArrayList<Node>(size);
        for (int i = 0; i < size; i++) {
            root.children.add(deserializeHelper(queue));
        }
        return root;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


}
