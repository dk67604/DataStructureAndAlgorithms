package main.java.techiedelight.binarytree;

public class VerticalSum {
    /*
    We can improve the time complexity of the
    above solution to linear by using a doublylinked list data structure. The idea here is to
    store the vertical sum of the binary tree in a
    doubly-linked list, where each node of the
    doubly linked list stores the sum of all nodes
    corresponding to a vertical line in a binary
    tree.
     */
    public static void verticalSum(Node root) {
        // create a new linked list node corresponding to the vertical line
        // passing through the root node
        ListNode curr = new ListNode(0, null, null);
        // calculate vertical sum and store it in a doubly-linked list
        updateDLLwithVerticalSum(root, curr);

        // print the linked list
        print(curr);

    }

    private static void updateDLLwithVerticalSum(Node root, ListNode curr) {
        if (root == null)
            return;
        // update the linked list node data corresponding to the vertical line
        // passing through the current tree node

        curr.data += root.data;
        // create a new linked list node corresponding to the vertical line
        // passing through the root's left child, if not already.
        // This node would be the `prev` pointer of the current list node
        if (root.left != null && curr.prev == null) {
            curr.prev = new ListNode(0, null, curr);
        }
        // create a new linked list node corresponding to the vertical line
        // passing through the root's right child, if not already.
        // This node would be the next pointer of the current list node
        if (root.right != null && curr.next == null) {
            curr.next = new ListNode(0, curr, null);
        }
        // recur for the left and right subtree
        updateDLLwithVerticalSum(root.left, curr.prev);
        updateDLLwithVerticalSum(root.right, curr.next);

    }

    // Function to print the vertical sum stored in a given doubly linked list
    private static void print(ListNode mid) {
        //move to head
        while (mid != null && mid.prev != null) {
            mid = mid.prev;
        }
        ListNode head = mid;
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        /* Construct the following tree
                1
              /   \
             /     \
            2       3
                  /   \
                 /     \
                5       6
              /   \
             /     \
            7       8
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        verticalSum(root);
    }

}
