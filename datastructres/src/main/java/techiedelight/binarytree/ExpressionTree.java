package main.java.techiedelight.binarytree;

import java.util.Stack;

// Construct an expression tree from a postfix notation and print the infix notation
public class ExpressionTree {

    public static void main(String[] args) {
        ExpressionTree expressionTree = new ExpressionTree();
        String postfix = "ab+cde+**";
        Node root = expressionTree.construct(postfix);

        System.out.print("Postfix Expression    : ");
        expressionTree.postorder(root);

        System.out.print("\nInfix Expression    : ");
        expressionTree.inorder(root);
    }

    private boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }

    private void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val);
    }

    private void inorder(Node root) {
        if (root == null) {
            return;
        }
        // if the current token is an operator, print open parenthesis
        if (isOperator(root.val)) {
            System.out.print("(");
        }
        inorder(root.left);
        System.out.print(root.val);
        inorder(root.right);
        // if the current token is an operator, print close parenthesis
        if (isOperator(root.val)) {
            System.out.print(")");
        }
    }

    // Function to construct an expression tree from the given postfix expression
    public Node construct(String postfix) {
        // create an empty stack to store tree pointer
        Stack<Node> s = new Stack<>();
        //traverse the postfix expression
        for (char c : postfix.toCharArray()) {
            // if the current token is operator
            if (isOperator(c)) {
                //pop two nodes 'x' and 'y' from the stack
                Node x = s.pop();
                Node y = s.pop();
                // construct a new binary tree whose root is the operator and whose
                // left and right children point to `y` and `x`, respectively
                Node node = new Node(c);
                node.left = y;
                node.right = x;
                // push the current node into the stack
                s.add(node);
            }
            // if the current token is an operand, create a new binary tree node
            // whose root is the operand push it into the stack
            else {
                s.add(new Node(c));
            }
        }
        return s.peek();
    }
}
