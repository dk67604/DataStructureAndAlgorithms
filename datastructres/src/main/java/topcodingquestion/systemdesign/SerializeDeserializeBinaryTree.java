package main.java.topcodingquestion.systemdesign;

import main.java.topcodingquestion.treesandgraphs.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String result = helper(root, "");
        return result;
    }

    private String helper(TreeNode node, String res) {
        if (node == null) {
            res += "#,";
            return res;
        } else {
            res += node.val + ",";
            res = helper(node.left, res);
            res = helper(node.right, res);
        }
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] temp = data.split(",");
        List<String> data_list = new ArrayList<>(Arrays.asList(temp));
        return helper(data_list);
    }

    private TreeNode helper(List<String> l) {
        if (l.get(0).equals("#")) {
            l.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = helper(l);
        root.right = helper(l);
        return root;
    }
}
