package main.java.leetcode.nary_tree;
class NewNode{
    int data;
    NewNode left;
    NewNode middle;
    NewNode right;
    public NewNode(int data){
        this.data = data;
        left=middle=right=null;
    }
}
public class TernaryToDLL {
    static NewNode tail;

    public static void push(NewNode node){
        //to put the node at the end of
        // the already existing tail.
        tail.right = node;
        //to point to the previous node.
        node.left = tail;
        // middle pointer should point to
        // nothing so null. initiate right
        // pointer to null.
        node.middle = node.right = null;
        // update the tail position
        tail = node;
    }
     /* Create a doubly linked list out of given a ternary tree.
    by traversing the tree in preorder fashion. */
    public static void ternaryTree(NewNode node, NewNode head){
        if (node == null)
            return;
        NewNode left = node.left;
        NewNode middle = node.middle;
        NewNode right = node.right;
        if(tail != node)
        // already root is in the tail so don't push
        // the node when it was root.In the first
        // case both node and tail have root in them.
            push(node);
        // First the left child is to be taken.
        // Then middle and then right child.
        ternaryTree(left,head);
        ternaryTree(middle,head);
        ternaryTree(right,head);
    }

    public static NewNode startTree(NewNode root){
        NewNode head = root;
        tail = root;
        ternaryTree(root, head);
        return head;
    }
    // Utility function for printing double linked list.
    public static void printList(NewNode head)
    {
        System.out.print("Created Double Linked list is:\n");
        while(head != null)
        {
            System.out.print(head.data + " ");
            head = head.right;
        }
    }

    // Driver program to test above functions
    public static void main(String args[])
    {

        // Constructing ternary tree as shown
        // in above figure
        NewNode root = new NewNode(30);
        root.left = new NewNode(5);
        root.middle = new NewNode(11);
        root.right = new NewNode(63);
        root.left.left = new NewNode(1);
        root.left.middle = new NewNode(4);
        root.left.right = new NewNode(8);
        root.middle.left = new NewNode(6);
        root.middle.middle = new NewNode(7);
        root.middle.right = new NewNode(15);
        root.right.left = new NewNode(31);
        root.right.middle = new NewNode(55);
        root.right.right = new NewNode(65);

        // The function which initiates the list
        // process returns the head.
        NewNode head = startTree(root);
        printList(head);
    }


}
