package main.java.leetcode;

public class ConvertSortedListToBinarySearchTree {
    private ListNode head;

    private int findSize(ListNode head){
        ListNode ptr = head;
        int c = 0;
        while(ptr!=null){
            ptr = ptr.next;
            c+=1;
        }
        return c;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int size = this.findSize(head);
        this.head = head;
        return convertListToBST(0,size-1);

    }
    private TreeNode convertListToBST(int l, int r){
        //invalid case
        if(l>r){
            return null;
        }

        int mid = (l+r)/2;
        //First step of simulated inorder traversal. Recursively from
        //the left half
        TreeNode left = this.convertListToBST(l,mid-1);
        // Once left half is traversed, process the current node
        TreeNode node = new TreeNode(this.head.val);
        node.left = left;
        // Maintain the invariance mentioned in the algorithm
        this.head = this.head.next;
        node.right = this.convertListToBST(mid+1,r);
        return node;

    }

}
