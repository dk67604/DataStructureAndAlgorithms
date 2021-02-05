package main.java.techiedelight.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// Approach use to do Spiral Order traversal and push the elements at the head of DLL
public class ConvertBinaryTreeToDLL {
    // Helper function to print a doubly linked list
    public static void printDoublyLinkedList(Node node) {
        while (node != null) {
            System.out.print(node.data + " —> ");
            node = node.right;
        }

        System.out.print("null");
    }

    public static void main(String[] args) {
        /* Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            /   \   /   \
           4     5 6     7
        */


        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        ConvertBinaryTreeToDLL convertBinaryTreeToDLL = new ConvertBinaryTreeToDLL();
        Node head = null;
        head = convertBinaryTreeToDLL.convert(root, head);
        printDoublyLinkedList(head);
    }

    // Insert a tree node at the front of the doubly linked list
    private Node push(Node node, Node head) {
        // initialize head pointer of the doubly linked list
        if (head == null) {
            head = node;
            head.left = null;
            node.right = null;
            return head;
        }
        // insert the given node at the front of the doubly linked list
        head.left = node;
        node.right = head;
        // update left child pointer to be null
        node.left = null;
        // update head pointer to point to the given node
        head = node;
        return head;
    }

    // Function to convert a binary tree into a doubly-linked list
    // using spiral order traversal
    public Node convert(Node root, Node head) {
        //base case
        if (root == null) {
            return head;
        }
        // create an empty double-ended queue and enqueue the root node
        Deque<Node> deque = new ArrayDeque<>();
        deque.addFirst(root);

        // flag is used to differentiate between odd or even level
        boolean flag = false;

        //create a stack for storing binary tree nodes in spiral order
        Stack<Node> stack = new Stack<>();
        while (!deque.isEmpty()) {
            int size = deque.size();
            // process level from left to right
            if (flag) {
                // pop from the front when the flag is true
                while (size > 0) {
                    Node curr = deque.pollFirst();
                    // push the left child into the back, followed by the right child
                    if (curr.left != null)
                        deque.addLast(curr.left);

                    if (curr.right != null)
                        deque.addLast(curr.right);
                    // push the current node into the stack
                    stack.push(curr);
                    size--;
                }

            } else {
                // process level right to left
                while (size > 0) {
                    // pop from the last when the flag is false
                    Node curr = deque.pollLast();
                    // push the right child into the front, followed by the left child
                    if (curr.right != null)
                        deque.addFirst(curr.right);

                    if (curr.left != null)
                        deque.addFirst(curr.left);
                    // push the current node into the stack
                    stack.push(curr);
                    size--;
                }
            }
            // flip `flag` for the next level
            flag = !flag;
        }
        while (!stack.isEmpty()) {
            head = push(stack.pop(), head);
        }
        return head;
    }
}
