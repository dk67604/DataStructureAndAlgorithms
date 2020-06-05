package main.java.arraysstrings;

public class ConstructLinkedList {

    public int solution(int[] A) {
       int size =1;
        NodeCus head = new NodeCus(A[0]);
        NodeCus temp = head;
        for(int i = 1; i< A.length;i++){
            int val = temp.val;
            NodeCus newNode = new NodeCus(A[val]);
            temp.next = newNode;
            temp = newNode;
            size++;
            if(temp.val == -1)
                return size;

        }
        return  size;

    }

    public static void main(String[] args) {
        int[] A = {1,4,-1,3,2};
        ConstructLinkedList constructLinkedList = new ConstructLinkedList();
        System.out.println(constructLinkedList.solution(A));
    }
}
