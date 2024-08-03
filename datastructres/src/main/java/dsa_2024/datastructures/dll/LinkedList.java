package main.java.dsa_2024.datastructures.dll;

class ListNode{
    int val;
    ListNode prev;
    ListNode next;

    public ListNode(int val){
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

public class LinkedList {

    ListNode left; // head
    ListNode right; //right

    public LinkedList(){
        left = new ListNode(0);
        right = new ListNode(0);
        left.next = right;
        right.prev = left;
    }

    public int get(int index){
        ListNode current = left.next;
        while (current!=null && index > 0) {
            current = current.next;
            index -= 1;
        }

        if (current != null && current != right && index ==0){
            return current.val;
        }
        return -1;
    }

    public void addToHead(int val){
        ListNode node = new ListNode(val);
        ListNode temp = left.next;
        ListNode prev = left;
        prev.next = node;
        temp.prev = node;
        node.next = temp;
        node.prev = prev;
    }

    public void addToTail(int val){
        ListNode node = new ListNode(val);
        ListNode temp = right;
        ListNode prev = right.prev;
        prev.next = node;
        temp.prev = node;
        node.next = temp;
        node.prev = prev;
    }

    public void addAtIndex(int index, int val){
        ListNode current = left.next;
        while (current != null && index > 0 ) {
            current = current.next;
            index -=1;
        }
        if ( current != null && index == 0){
            ListNode node = new ListNode(val);
            ListNode temp = current;
            ListNode prev = current.prev;
            prev.next = node;
            temp.prev = node;
            node.next = temp;
            node.prev = prev;
        }
    }

    public void deleteAtIndex(int index){
        ListNode current = left.next;
        while (current != null && index > 0 ) {
            current = current.next;
            index -=1;
        }
        if(current != null && current != right && index ==0){
            ListNode temp = current.next;
            ListNode prev = current.prev;
            temp.prev = prev;
            prev.next = temp;
        }
    }

    public void traverse(){
        ListNode current = left.next;
        while (current != null && current !=right) {
            if (current.next == right){
                System.out.println(current.val + " ->  None");
            }
            else{
                System.out.print(current.val + " -> ");
            }
            current = current.next;
        }
    }
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7,8,9};
        LinkedList linkedList = new LinkedList();
        for (int num : nums){
            linkedList.addToTail(num);
        }
        linkedList.traverse();
        linkedList.deleteAtIndex(3);
        linkedList.traverse();
        linkedList.addAtIndex(3, 4);
        linkedList.traverse();
        linkedList.addAtIndex(9, 10);
        linkedList.traverse();
        linkedList.addToHead(11);
        linkedList.traverse();




    }

}
