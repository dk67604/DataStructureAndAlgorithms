package main.java.topcodingquestion.treesandgraphs;

//https://www.techiedelight.com/place-convert-given-binary-tree-to-doubly-linked-list/
// The left and right pointers of
public class BinaryTreeToDLL {
    // Function to in-place convert a given binary tree into a doubly linked list
    // by doing normal inorder traversal
    public static TreeNode convert(TreeNode root, TreeNode head) {
        if (root == null)
            return head;
        // recursively convert the left subtree first
        head = convert(root.left, head);
        // store right child
        TreeNode right = root.right;
        // insert the current node at the beginning of a doubly linked list
        root.right = head;
        if (head != null) {
            head.left = root;
        }
        head = root;
        // recursively convert the right subtree
        return convert(right, head);
    }

    // Function to reverse a doubly-linked list
    public static TreeNode reverse(TreeNode head) {
        TreeNode prev = null;
        TreeNode current = head;
        while (current != null) {
            // swap current.left with current.right
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            prev = current;
            current = current.left;
        }
        return prev;
    }

    public static void printDLL(TreeNode head) {
        TreeNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
    }

    public static void convert(TreeNode root) {
        // head of the doubly linked list
        TreeNode head = null;
        // convert the above binary tree into doubly linked list
        head = convert(root, head);
        head = reverse(head);
        //print DLL
        printDLL(head);
    }

    public static void main(String[] args) {
        /* Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            4   5   6   7
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        convert(root);

    }
}
